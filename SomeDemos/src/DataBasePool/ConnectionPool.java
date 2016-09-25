package DataBasePool;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * Created by lwy on 2016/6/15.
 */
public class ConnectionPool {
    private LinkedList<Connection> pool = new LinkedList<>();

    public ConnectionPool(int initialSize) {
        if (initialSize > 0) {
            for (int i = 0; i < initialSize; i++) {
                pool.add(ConnectionDriver.createConnection());
            }
        }
    }

    public void releaseConnection(Connection connection) {
        if (connection != null) {
            synchronized (pool) {
                pool.addLast(connection);
                pool.notifyAll();
            }
        }
    }

    public Connection fetchConnection(long milis) throws InterruptedException {
        synchronized (pool) {
            if (milis <= 0) {
                while (pool.isEmpty()) {
                    pool.wait();
                }
                return pool.removeFirst();
            } else {
                long future = System.currentTimeMillis() + milis;
                long remaining = milis;
                while (pool.isEmpty() && remaining > 0) {
                    pool.wait(remaining);
                    remaining = future - System.currentTimeMillis();
                }
//                pool.wait(milis);
                Connection result = null;
                if (!pool.isEmpty())
                    result = pool.removeFirst();
                return result;
            }
        }
    }
}
