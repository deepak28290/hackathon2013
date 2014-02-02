package com.ebay.redis.repository;
import java.io.Serializable;

public interface DomainObject extends Serializable {
 
 String getKey();
 
 String getObjectKey();
}
