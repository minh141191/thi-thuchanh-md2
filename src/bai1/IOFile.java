package bai1;

import java.util.ArrayList;
import java.util.List;

public interface IOFile<E> {
    void write(List<E> e, String path);
    public ArrayList<E> read(String path);
}
