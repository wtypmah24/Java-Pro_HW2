package org.HW_110124.task_2.connection;

public class FastConnection extends Connection implements Cloneable{
    public FastConnection(String host, String port, String protocol) {
        super(host, port, protocol);
    }
    @Override
    public FastConnection clone() {
        try {
            return (FastConnection) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}