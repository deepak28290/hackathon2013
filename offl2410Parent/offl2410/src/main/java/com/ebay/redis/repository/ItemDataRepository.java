/*package com.ebay.redis.repository;
import java.util.ArrayList;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
 
 
public class ItemDataRepository implements Repository<ItemData>{
 
 @Autowired
 private RedisTemplate<String,ItemData> redisTemplate;
  
 public RedisTemplate<String,ItemData> getRedisTemplate() {
  return redisTemplate;
 }
 
 public void setRedisTemplate(RedisTemplate<String,ItemData> redisTemplate) {
  this.redisTemplate = redisTemplate;
 }
 
 @Override
 public void put(ItemData idata) {
  redisTemplate.opsForHash()
    .put(idata.getObjectKey(), idata.getKey(), idata);
 }
 
 @Override
 public void delete(ItemData key) {
  redisTemplate.opsForHash().delete(key.getObjectKey(), key.getKey());
 }
 
 @Override
 public ItemData get(ItemData key) {
  return (ItemData) redisTemplate.opsForHash().get(key.getObjectKey(),
    key.getKey());
 }
 public ItemData getByItemId(String itemid) {
	  return (ItemData) redisTemplate.opsForHash().get(itemid,
	    key.getKey());
	 }
 @Override
 public List<ItemData> getObjects() {
  List<ItemData> idList = new ArrayList<ItemData>();
  for (Object id : redisTemplate.opsForHash().values(ItemData.OBJECT_KEY) ){
   idList.add((ItemData) id);
  }
  return idList;
 }
}*/