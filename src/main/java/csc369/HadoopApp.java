package csc369;

import java.io.IOException;


import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

public class HadoopApp {

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        Configuration conf = new Configuration();
        Job job = new Job(conf, "Hadoop example");
        String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();

		if (otherArgs.length < 3) {
			System.out.println("Expected parameters: <job class> <input dir> <output dir>");
			System.exit(-1);
		} else if ("AccessLog1".equalsIgnoreCase(otherArgs[0])) {
			job.setReducerClass(AccessLog.ReducerImpl.class);
			job.setMapperClass(AccessLog.MapperImpl.class);
			job.setOutputKeyClass(AccessLog.OUTPUT_KEY_CLASS);
			job.setOutputValueClass(AccessLog.OUTPUT_VALUE_CLASS);
		} else if ("AccessLog2".equalsIgnoreCase(otherArgs[0])) {
			job.setReducerClass(AccessLog2.ReducerImpl.class);
			job.setMapperClass(AccessLog2.MapperImpl.class);
			job.setOutputKeyClass(AccessLog2.OUTPUT_KEY_CLASS);
			job.setOutputValueClass(AccessLog2.OUTPUT_VALUE_CLASS);
		} else if ("AccessLog3".equalsIgnoreCase(otherArgs[0])) {
			job.setReducerClass(AccessLog3.ReducerImpl.class);
			job.setMapperClass(AccessLog3.MapperImpl.class);
			job.setOutputKeyClass(AccessLog3.OUTPUT_KEY_CLASS);
			job.setOutputValueClass(AccessLog3.OUTPUT_VALUE_CLASS);
		} else if ("AccessLog4".equalsIgnoreCase(otherArgs[0])) {
			job.setReducerClass(AccessLog4.ReducerImpl.class);
			job.setMapperClass(AccessLog4.MapperImpl.class);
			job.setOutputKeyClass(AccessLog4.OUTPUT_KEY_CLASS);
			job.setOutputValueClass(AccessLog4.OUTPUT_VALUE_CLASS);
		} else if ("AccessLog5".equalsIgnoreCase(otherArgs[0])) {
			job.setReducerClass(AccessLog5.ReducerImpl.class);
			job.setMapperClass(AccessLog5.MapperImpl.class);
			job.setOutputKeyClass(AccessLog5.OUTPUT_KEY_CLASS);
			job.setOutputValueClass(AccessLog5.OUTPUT_VALUE_CLASS);
		} else if ("AccessLog6".equalsIgnoreCase(otherArgs[0])) {
			job.setReducerClass(AccessLog6.ReducerImpl.class);
			job.setMapperClass(AccessLog6.MapperImpl.class);
			job.setOutputKeyClass(AccessLog6.OUTPUT_KEY_CLASS);
			job.setOutputValueClass(AccessLog6.OUTPUT_VALUE_CLASS);
		}
		else {
			System.out.println("Unrecognized job: " + otherArgs[0]);
			System.exit(-1);
		}

		FileInputFormat.addInputPath(job, new Path(otherArgs[1]));
		FileOutputFormat.setOutputPath(job, new Path(otherArgs[2]));

		int complete = job.waitForCompletion(true) ? 0 : 1;

		if (otherArgs[0].contains("1") ||
						otherArgs[0].contains("4") ||
						otherArgs[0].contains("6")) {
			Configuration conf2 = new Configuration();
			Job sortValues = new Job(conf2, "Hadoop example");
			FileInputFormat.addInputPath(sortValues, new Path(otherArgs[2]));
			FileOutputFormat.setOutputPath(sortValues, new Path("b"+otherArgs[2]));

			sortValues.setReducerClass(AccessLog8.ReducerImpl.class);
			sortValues.setMapperClass(AccessLog8.MapperImpl.class);
			sortValues.setOutputKeyClass(AccessLog8.OUTPUT_KEY_CLASS);
			sortValues.setOutputValueClass(AccessLog8.OUTPUT_VALUE_CLASS);

			System.exit(sortValues.waitForCompletion(true) ? 0 : 1);
		}
		System.exit(complete);
	}

}

