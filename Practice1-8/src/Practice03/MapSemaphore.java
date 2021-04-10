package Practice03;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Semaphore;

public class MapSemaphore<K, V> implements Map<K, V> {
    private  static final Semaphore semaphore = new Semaphore(1);
    private final Map<K, V> map = new HashMap<>();

    @Override
    public int size() {
        int size = 0;
        try {
            semaphore.acquire();
            size = map.size();
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        boolean res = false;
        try {
            semaphore.acquire();
            res = map.isEmpty();
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public boolean containsKey(Object key) {
        boolean res = false;
        try {
            semaphore.acquire();
            res = map.containsKey(key);
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public boolean containsValue(Object value) {
        boolean res = false;
        try {
            semaphore.acquire();
            res = map.containsValue(value);
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public V get(Object key) {
        V res = null;
        try {
            semaphore.acquire();
            res = map.get(key);
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public V put(K key, V value) {
        V res = null;
        try {
            semaphore.acquire();
            res = map.put(key, value);
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public V remove(Object key) {
        V res = null;
        try {
            semaphore.acquire();
            res = map.remove(key);
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        try {
            semaphore.acquire();
            map.putAll(m);
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void clear() {

    }

    @Override
    public Set<K> keySet() {
        Set<K> res = null;
        try {
            semaphore.acquire();
            res = map.keySet();
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public Collection<V> values() {
        Collection<V> res = null;
        try {
            semaphore.acquire();
            res = map.values();
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> res = null;
        try {
            semaphore.acquire();
            res = map.entrySet();
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return res;
    }


}
