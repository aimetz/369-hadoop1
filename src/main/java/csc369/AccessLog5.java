package csc369;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;

public class AccessLog5 {


    public static final Class OUTPUT_KEY_CLASS = Text.class;
    public static final Class OUTPUT_VALUE_CLASS = IntWritable.class;

    public static class MapperImpl extends Mapper<LongWritable, Text, Text, IntWritable> {
        private IntWritable one = new IntWritable(1);
//        private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("[dd/MMM/yyyy:HH:mm:ss");
//        private LocalDate dateTime;// = LocalDate.parse(dateInString, formatter);
        @Override
        protected void map(LongWritable key, Text value,
                           Context context) throws IOException, InterruptedException {
            String[] sa = value.toString().split(" ");
            Text hostname = new Text();
//            dateTime = LocalDate.parse(sa[3], formatter);
            hostname.set(sa[3].substring(4, 12));
            context.write(hostname, one);
        }
    }

    public static class ReducerImpl extends Reducer<Text, IntWritable, Text, IntWritable> {
        private IntWritable result = new IntWritable();

        @Override
        protected void reduce(Text hostname, Iterable<IntWritable> intOne,
                              Context context) throws IOException, InterruptedException {
            int sum = 0;
            Iterator<IntWritable> itr = intOne.iterator();

            while (itr.hasNext()){
                sum  += itr.next().get();
            }
            result.set(sum);
            context.write(hostname, result);
        }
    }

}

