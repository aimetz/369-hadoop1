package csc369;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.RawComparator;

public class DescendingIntWritableComparable extends IntWritable {
    /**
     * A decreasing Comparator optimized for IntWritable.
     */
    public static abstract class DecreasingComparator implements RawComparator {
        public int compare(WritableComparable a, WritableComparable b) {
            return -compare(a, b);
        }

        public int compare(int s2, int l2) {
            return -compare(s2, l2);
        }

        @Override
        public int compare(Object o1, Object o2) {

            return 0;
        }

        @Override
        public boolean equals(Object obj) {
            return false;
        }
    }
}
