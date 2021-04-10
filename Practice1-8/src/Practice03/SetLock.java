package Practice03;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SetLock<E> implements Set<E> {
    private static final Lock lock = new ReentrantLock();
    private final Set<E> set = new HashSet<>();

    @Override
    public int size() {
        lock.lock();
        int res = set.size();
        lock.unlock();
        return res;
    }

    @Override
    public boolean isEmpty() {
        lock.lock();
        boolean res = set.isEmpty();
        lock.unlock();
        return res;
    }

    @Override
    public boolean contains(Object o) {
        lock.lock();
        boolean res = set.contains(o);
        lock.unlock();
        return res;
    }

    @Override
    public Iterator<E> iterator() {
        lock.lock();
        Iterator<E> iterator = set.iterator();
        lock.unlock();
        return iterator;
    }

    @Override
    public Object[] toArray() {
        lock.lock();
        Object[] array = set.toArray();
        lock.unlock();
        return array;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        lock.lock();
        Object[] array = set.toArray();
        lock.unlock();
        return (T[]) array;
    }

    @Override
    public boolean add(E e) {
        lock.lock();
        boolean res = set.add(e);
        lock.unlock();
        return res;
    }

    @Override
    public boolean remove(Object o) {
        lock.lock();
        boolean res = set.remove(o);
        lock.unlock();
        return res;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        lock.lock();
        boolean res = set.containsAll(c);
        lock.unlock();
        return res;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        lock.lock();
        boolean res = set.addAll(c);
        lock.unlock();
        return res;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        lock.lock();
        boolean res = set.retainAll(c);
        lock.unlock();
        return res;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        lock.lock();
        boolean res = set.removeAll(c);
        lock.unlock();
        return res;
    }

    @Override
    public void clear() {
        lock.lock();
        set.clear();
        lock.unlock();
    }
}
