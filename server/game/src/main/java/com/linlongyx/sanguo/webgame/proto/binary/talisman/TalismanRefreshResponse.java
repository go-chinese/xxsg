/*    */ package com.linlongyx.sanguo.webgame.proto.binary.talisman;
/*    */ 
/*    */ import com.linlongyx.core.framework.protocol.ResponseBase;
/*    */ import com.linlongyx.sanguo.webgame.proto.ProtocolUtil;
/*    */ import com.linlongyx.sanguo.webgame.proto.binary.struct.IntIntValue;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import java.util.ArrayList;
/*    */ import org.msgpack.annotation.Message;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Message
/*    */ public class TalismanRefreshResponse
/*    */   extends ResponseBase
/*    */ {
/* 20 */   public ArrayList<IntIntValue> itemList = new ArrayList<>();
/*    */   public byte freeRefresh;
/*    */   public int refreshTimes;
/*    */   
/*    */   public TalismanRefreshResponse() {
/* 25 */     this.eventResponseId = 22901;
/* 26 */     this.codeType = 2;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void serial(ByteBuf out) {
/* 32 */     int size_0 = this.itemList.size();
/* 33 */     ProtocolUtil.writeStrArraySize(out, size_0);
/* 34 */     for (int index_0 = 0; index_0 < size_0; index_0++) {
/*    */       
/* 36 */       IntIntValue tmp_0 = this.itemList.get(index_0);
/* 37 */       tmp_0.serial(out);
/*    */     } 
/* 39 */     ProtocolUtil.writeByte(out, this.freeRefresh);
/* 40 */     ProtocolUtil.writeInt(out, this.refreshTimes);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void unserial(ByteBuf in) {
/* 46 */     int size_0 = ProtocolUtil.readStrArraySize(in);
/* 47 */     for (int index_0 = 0; index_0 < size_0; index_0++) {
/*    */       
/* 49 */       IntIntValue tmp_0 = new IntIntValue();
/* 50 */       tmp_0.unserial(in);
/* 51 */       this.itemList.add(tmp_0);
/*    */     } 
/* 53 */     this.freeRefresh = ProtocolUtil.readUTFBinByte(in);
/* 54 */     this.refreshTimes = ProtocolUtil.readUTFBinInt(in);
/*    */   }
/*    */ 
/*    */   
/*    */   public TalismanRefreshResponse clone() throws CloneNotSupportedException {
/* 59 */     TalismanRefreshResponse clone = (TalismanRefreshResponse)super.clone();
/* 60 */     int size_0 = this.itemList.size();
/* 61 */     for (int index_0 = 0; index_0 < size_0; index_0++) {
/*    */       
/* 63 */       IntIntValue tmp_0 = this.itemList.get(index_0);
/* 64 */       clone.itemList.add(tmp_0.clone());
/*    */     } 
/* 66 */     return clone;
/*    */   }
/*    */ 
/*    */   
/*    */   public void reset() {
/* 71 */     this.itemList.clear();
/* 72 */     this.freeRefresh = 0;
/* 73 */     this.refreshTimes = 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 78 */     String retVal = "{\"itemList\":" + this.itemList.toString() + ",\"freeRefresh\":" + this.freeRefresh + ",\"refreshTimes\":" + this.refreshTimes + "}";
/* 79 */     return retVal;
/*    */   }
/*    */ }


/* Location:              D:\xxsg_52gmsy\game\target\classes\!\com\linlongyx\sanguo\webgame\proto\binary\talisman\TalismanRefreshResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */