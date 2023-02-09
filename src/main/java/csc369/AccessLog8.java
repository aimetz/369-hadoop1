package csc369;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;

public class AccessLog8 {

    public static final Class OUTPUT_KEY_CLASS = IntWritable.class;
    public static final Class OUTPUT_VALUE_CLASS = Text.class;

    public static class MapperImpl extends Mapper<IntWritable, Text, IntWritable, Text> {

        @Override
	protected void map(IntWritable key, Text value,
			   Context context) throws IOException, InterruptedException {
	    String[] sa = value.toString().split(" ");
	    Text hostname = new Text();
        hostname.set(sa[0]);
        IntWritable count = new IntWritable(Integer.parseInt(sa[1]));
	    context.write(count, hostname);
        }
    }

    
    public static class ReducerImpl extends Reducer<IntWritable, Text, Text, IntWritable> {
	
        @Override
	protected void reduce(IntWritable count, Iterable<Text> hostnames,
			      Context context) throws IOException, InterruptedException {
            
            Iterator<Text> itr = hostnames.iterator();
            while (itr.hasNext()){
                context.write(itr.next(), count);
            }
        }
    }

}
