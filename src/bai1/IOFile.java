package bai1;

import java.util.ArrayList;
import java.util.List;

public interface IOFile<E> {
    void write();
    public ArrayList<E> read();
}
