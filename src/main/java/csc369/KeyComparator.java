package csc369;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class KeyComparator extends WritableComparator {
    protected KeyComparator() {
        super(CustomKey.class, true);
    }
    @Override
    public int compare(WritableComparable w1, WritableComparable w2) {
        CustomKey ip1 = (CustomKey) w1;
        CustomKey ip2 = (CustomKey) w2;
        int cmp = ip1.getIP().compareTo(ip2.getIP());
        if (cmp != 0) {
            return cmp;
        }
        return ip2.getCount().compareTo(ip1.getCount()); //reverse
    }
}