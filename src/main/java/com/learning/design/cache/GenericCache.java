package com.learning.design.cache;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class GenericCache<K, V> implements IGenericCache<K, V> {

  //public static final Long DEFAULT_CACHE_TIMEOUT = 60000L;
  protected Map<K, CacheValue<V>> cacheMap;
  protected Long cacheTimeout;

  public GenericCache(Long cacheTimeout) {
    this.cacheTimeout = cacheTimeout;
    this.clear();
  }

  @Override
  public void clear() {
    this.cacheMap = new HashMap<>();
  }


  @Override
  public void clean() {
    for (K key : this.getExpiredKeys()) {
      this.remove(key);
    }
  }

  @Override
  public boolean containsKey(K key) {
    return this.cacheMap.containsKey(key);
  }

  protected Set<K> getExpiredKeys() {
    return cacheMap.keySet().parallelStream()
        .filter(this::isExpired)
        .collect(Collectors.toSet());
  }

  protected boolean isExpired(K key) {
    LocalDateTime expirationDateTime = cacheMap.get(key).createdAt.plus(this.cacheTimeout, ChronoUnit.MILLIS);
    return LocalDateTime.now().isAfter(expirationDateTime);
  }

  @Override
  public Optional<V> get(K key) {
    this.clean();
    return Optional.ofNullable(cacheMap.get(key).value);
  }

  @Override
  public void put(K key, V value) {
    cacheMap.put(key, new CacheValue<>(value));
  }

 /* protected CacheValue<V> createCacheValue(V value) {
    return new CacheValue(value);
  }*/


  @Override
  public void remove(K key) {
    cacheMap.remove(key);
  }

  class CacheValue<V> {
    V value;
    LocalDateTime createdAt;
    CacheValue(V value) {
      this.value = value;
      this.createdAt = LocalDateTime.now();
    }
  }

  public static void main(String[] args) {
    GenericCache<Integer,Integer> genericCache=new GenericCache<>(100l);
    genericCache.put(10,10);
  }
}
