package csc369;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import org.apache.hadoop.io.WritableComparable;

public class CustomKey implements WritableComparable<CustomKey> {
    private String ip;
    private Integer count;

    public String getIP() {
        return ip;
    }

    public Integer getCount() {
        return count;
    }
    public void setCount(Integer count) {
        this.count = count;
    }
    @Override
    public void write(DataOutput out) throws IOException {
//        out.write(ip);
        out.writeInt(count);

    }
    @Override
    public void readFields(DataInput in) throws IOException {
        ip = in.readLine();
        count = in.readInt();
    }
    @Override
    public int compareTo(CustomKey o) {
        int comparedValue = count.compareTo(o.getCount());
        if (comparedValue != 0) {
            return comparedValue;
        }
        return count.compareTo(o.getCount());
    }

}