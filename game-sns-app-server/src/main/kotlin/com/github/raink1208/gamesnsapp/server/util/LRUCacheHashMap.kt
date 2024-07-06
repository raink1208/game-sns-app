package com.github.raink1208.gamesnsapp.server.util


class LRUCacheHashMap<K, V>(private val maxSize: Int): LinkedHashMap<K, V>(16, 0.75f, true) {
    override fun removeEldestEntry(eldest: MutableMap.MutableEntry<K, V>): Boolean {
        return size > maxSize
    }
}