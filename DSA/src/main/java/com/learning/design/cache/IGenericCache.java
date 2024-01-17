package com.learning.design.cache;

import java.util.Optional;

public interface IGenericCache<K, V> {
//https://medium.com/@marcellogpassos/creating-a-simple-and-generic-cache-manager-in-java-e62e4204a10e
  void put(K key, V value);//Put: stores a new entry to the cache, associated with a search key.

  Optional<V> get(K key);//Get: given a key, retrieves a value stored in the cache.

  void remove(K key);//Remove: given a key, removes an entry from the cache.

  boolean containsKey(K key);//Contains key: check if a certain key is already stored in the cache.

  void clear();//Clean: removes all expired cache entries.

  void clean();//Clear: removes all entries from the cache.

}
