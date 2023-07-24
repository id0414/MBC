package com.busanbank.MBC.eai;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ThreadLocalRandom;

import com.busanbank.MBC.eai.telegram.BizCommonConstant;
import com.busanbank.MBC.eai.telegram.EAITelegram;
import com.busanbank.MBC.eai.telegram.SystemCommonConstant;

public class EAISocketClient {
  private String host;
  private int port;
  private int timeout = 180;

  public EAISocketClient() {

  }

  public EAISocketClient(String host, int port, int timeout) {
    this.host = host;
    this.port = port;
    this.timeout = timeout;
  }

  public byte[] request(byte[] telegram) throws Exception {
    Socket socket = null;
    OutputStream os = null;
    InputStream is = null;
    ByteArrayOutputStream out = null;
    byte[] rtnTelegram = null;

    try {
      // 서버 접속
      socket = new Socket(host, port);
      os = socket.getOutputStream();
      os.write(telegram);
      os.flush();
      socket.shutdownOutput();

      socket.setSoTimeout(timeout * 1000);

      int offset = 0;
      int len = 0;

      int lengthOffset = 0;
      int lengthSize = 8;

      int initialSize = 8;
      byte[] header = new byte[lengthOffset + lengthSize];
      byte[] lengData = new byte[lengthSize];
      int dataLen = 0;

      is = socket.getInputStream();
      len = is.read(header);
      offset += len;
      if (len == -1) {
        throw new IOException();
      }

      while (offset < header.length) {
        len = is.read(header, offset, header.length - offset);
        offset += len;
        if (len == -1) {
          throw new IOException();
        }
      }

      System.arraycopy(header, header.length - lengthSize, lengData, 0, lengthSize);
      dataLen = Integer.parseInt(new String(lengData).trim()) - lengthSize + initialSize;

      out = new ByteArrayOutputStream();
      out.write(header);

      byte[] body = new byte[dataLen];
      offset = 0;
      len = is.read(body, 0, body.length);
      offset += len;
      if (len == -1) {
        throw new IOException();
      }

      while (offset < body.length) {
        len = is.read(body, offset, body.length - offset);
        offset += len;
        if (len == -1) {
          throw new IOException();
        }
      }
      out.write(body);
      out.flush();
      rtnTelegram = out.toByteArray();
    } catch(Exception e) {
      throw e;
    } finally {
      if (os != null) {
        try {
          os.close();
        } catch (IOException e) {

        }
      }
      if (is != null) {
        try {
          is.close();
        } catch (IOException e) {
          
        }
      }
      if (out != null) {
        try {
          out.close();
        } catch (IOException e) {
          
        }
      }
      if (socket != null) {
        try {
          socket.close();
        } catch (IOException e) {
          
        }
      }
    }
    return rtnTelegram;
  }

  private static String getGblId() {
    Date today = Calendar.getInstance().getTime();
    StringBuffer sb = new StringBuffer();
    sb.append(new SimpleDateFormat("yyyyMMdd").format(today));
    // FIXME StringUtils가 없음
    //sb.append(StringUtils.rpad("MBS", 8, '0'));
    sb.append("00000000");
    sb.append(new SimpleDateFormat("HHmmssSSS").format(today));
    sb.append(ThreadLocalRandom.current().nextInt(10000, 100000));
    sb.append("00");
    return sb.toString();
  }

  public static byte[] makeTelegram(String confInfoDvcd, String interfaceId, String inputTelegramId, String inputTelegramLwrId, Map<String, String> telegramBody) throws Exception {
    EAITelegram telegram = new EAITelegram();
    String guid = getGblId();
    /*
     * 전문 시스템공통부
     */
    // 전문 전체 사이즈
    telegram.setSystemCommonItem(SystemCommonConstant.STD_GRAM_LEN, EAITelegram.expand(SystemCommonConstant.STD_GRAM_LEN.getLength(), Integer.toString(telegram.getTelegramLength() - 8), SystemCommonConstant.STD_GRAM_LEN.getType()));
    // EAI-INTERFACE-ID
    telegram.setSystemCommonItem(SystemCommonConstant.EAI_IF_ID, EAITelegram.expand(SystemCommonConstant.EAI_IF_ID.getLength(), interfaceId, SystemCommonConstant.EAI_IF_ID.getType()));
    // 전문작성일자
    Calendar calendar = Calendar.getInstance();
    telegram.setSystemCommonItem(SystemCommonConstant.GBL_ID_DATE, EAITelegram.expand(SystemCommonConstant.GBL_ID_DATE.getLength(), guid.substring(0, 8), SystemCommonConstant.GBL_ID_DATE.getType()));
    // 전문생성 시스템
    telegram.setSystemCommonItem(SystemCommonConstant.GBL_ID_SYSTEM_ID, EAITelegram.expand(SystemCommonConstant.GBL_ID_SYSTEM_ID.getLength(), guid.substring(8, 16), SystemCommonConstant.GBL_ID_SYSTEM_ID.getType()));
    // 표준전문번호
    telegram.setSystemCommonItem(SystemCommonConstant.GBL_ID_STANDARD_TELEGRAM, EAITelegram.expand(SystemCommonConstant.GBL_ID_STANDARD_TELEGRAM.getLength(), guid.substring(16, 30), SystemCommonConstant.GBL_ID_STANDARD_TELEGRAM.getType()));
    // 표준전문진행번호
    telegram.setSystemCommonItem(SystemCommonConstant.GBL_ID_STATUS_NUM, EAITelegram.expand(SystemCommonConstant.GBL_ID_STATUS_NUM.getLength(), guid.substring(30, 32), SystemCommonConstant.GBL_ID_STATUS_NUM.getType()));
    // 클라이언트 IP
    // 클라이언트 MAC
    // 환경정보구분코드
    telegram.setSystemCommonItem(SystemCommonConstant.CONF_INFO_DVCD, EAITelegram.expand(SystemCommonConstant.CONF_INFO_DVCD.getLength(), confInfoDvcd, SystemCommonConstant.CONF_INFO_DVCD.getType()));
    // 전문요청일시
    telegram.setSystemCommonItem(SystemCommonConstant.GRAM_RQST_DTTI, EAITelegram.expand(SystemCommonConstant.GRAM_RQST_DTTI.getLength(), new SimpleDateFormat("yyyyMMddHHmmssSSS").format(calendar.getTime()), SystemCommonConstant.GRAM_RQST_DTTI.getType()));


    /*
     * 전문 비지니스 공통부
     */
    // 소속그룹사코드
    telegram.setBizCommonItem(BizCommonConstant.BLG_CMGR_CD, EAITelegram.expand(BizCommonConstant.BLG_CMGR_CD.getLength(), "01", EAITelegram.ItemType.Text));
    // 취급점번
    telegram.setBizCommonItem(BizCommonConstant.TT_BRNO, EAITelegram.expand(BizCommonConstant.TT_BRNO.getLength(), "000", EAITelegram.ItemType.Text));
    // 모점점번
    telegram.setBizCommonItem(BizCommonConstant.MTBCNO, EAITelegram.expand(BizCommonConstant.MTBCNO.getLength(), "000", EAITelegram.ItemType.Text));
    // 행번
    telegram.setBizCommonItem(BizCommonConstant.ENOB, EAITelegram.expand(BizCommonConstant.ENOB.getLength(), "000", EAITelegram.ItemType.Text));
    // 점포구분코드
    //telegram.setBizCommonItem(BizCommonConstant.SHP_DVCD, EAITelegram.expand(BizCommonConstant.SHP_DVCD.getLength(), stfInfo.getString("shpDvcd"), EAITelegram.ItemType.Text));
    // 거래그룹사코드
    telegram.setBizCommonItem(BizCommonConstant.TRNS_CMGR_CD, EAITelegram.expand(BizCommonConstant.TRNS_CMGR_CD.getLength(), "01", EAITelegram.ItemType.Text));
    // 단말점번
    //telegram.setBizCommonItem(BizCommonConstant.TU_BRNO, EAITelegram.expand(BizCommonConstant.TU_BRNO.getLength(), stfInfo.getString("tuBrno"), EAITelegram.ItemType.Text));
    // 대행점번
    telegram.setBizCommonItem(BizCommonConstant.VE_BRNO, EAITelegram.expand(BizCommonConstant.VE_BRNO.getLength(), "000", EAITelegram.ItemType.Text));
    // 입력전문 ID
    telegram.setBizCommonItem(BizCommonConstant.INPUT_GRAM_ID, EAITelegram.expand(BizCommonConstant.INPUT_GRAM_ID.getLength(), inputTelegramId, EAITelegram.ItemType.Text));
    // 입력전문 하위 ID
    telegram.setBizCommonItem(BizCommonConstant.INPUT_GRAM_LWR_ID, EAITelegram.expand(BizCommonConstant.INPUT_GRAM_LWR_ID.getLength(), inputTelegramLwrId, EAITelegram.ItemType.Text));
  
    StringBuilder sb = new StringBuilder();
    for (Entry<String, String> ent : telegramBody.entrySet()) {
      sb.append(ent.getValue());
    }
    telegram.createIndividualTelegram(sb.append("@@").toString());
    telegram.setBizCommonItem(BizCommonConstant.DATA_LEN, EAITelegram.expand(BizCommonConstant.DATA_LEN.getLength(), Integer.toString(new String(telegram.getBizIndividual(), "utf-8").getBytes("euc-kr").length - 2), BizCommonConstant.DATA_LEN.getType()));

    byte[] encodingTelegram = new String(telegram.getTelegram(), "utf-8").getBytes("euc-kr");
    byte[] telegramLength = EAITelegram.expand(SystemCommonConstant.STD_GRAM_LEN.getLength(), Integer.toString(encodingTelegram.length - SystemCommonConstant.STD_GRAM_LEN.getLength()), EAITelegram.ItemType.Number).getBytes();

    System.arraycopy(telegramLength, 0, encodingTelegram, SystemCommonConstant.STD_GRAM_LEN.getOffset(), telegramLength.length);
    return encodingTelegram;
  }
}

