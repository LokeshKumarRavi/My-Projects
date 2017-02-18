import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
//import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

//73, High school graduate, Widowed, Female, Nonfiler,1700.09, Not in universe, United-States, Native- Born in the United States,0
//Number of Educated and un-educated (and Gender wise).
public class edu 
{

  public static class eduMapper extends Mapper<LongWritable, Text, Text, IntWritable>
  {
	 
	  public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException
	  {
		  
			  String[] str = value.toString().split(",");
			  String gender = str[3];
			  String Education = str[1];
			  int age = Integer.parseInt(str[0]);
			  
			  if(age>17)
			  {
				  if(gender.contains(" Female"))
				  {
					  if((Education.contains(" 9th grade") || Education.contains(" 5th or 6th grade") || Education.contains(" 7th and 8th grade")
							  || Education.contains(" 1st 2nd 3rd or 4th grade") || Education.contains(" Less than 1st grade")))
					  {
						  context.write(new Text("Uneducated Female :"), new IntWritable(1));
					  }
					  
					     
					  
				  }
				  if(gender.contains(" Male"))
				  {
					  if((Education.contains(" 9th grade") || Education.contains(" 5th or 6th grade") || Education.contains(" 7th and 8th grade")
							  || Education.contains(" 1st 2nd 3rd or 4th grade") || Education.contains(" Less than 1st grade")))
					  {
						  context.write(new Text("Uneducated Male :"), new IntWritable(1));
					  }
					  
				  }
			  }
			  if(gender.contains(" Male") && (Education.contains(" High school graduate") || Education.contains(" 12th grade no diploma") || 
			    		 Education.contains(" 11th grade") || Education.contains(" Doctorate degree(PhD EdD)") ||
			    		 Education.contains(" Bachelors degree(BA AB BS)") || Education.contains(" Some college but no degree") 
			    		 || Education.contains(" Associates degree-academic program") || Education.contains(" Associates degree-occup /vocational")
			    		 || Education.contains(" Masters degree(MA MS MEng MEd MSW MBA)") || Education.contains(" Prof school degree (MD DDS DVM LLB JD)")
			    		 || Education.contains(" 10th grade"))) 
			     {
			    	 context.write(new Text("Educated Male :  "), new IntWritable(1));
			     }
			  if(gender.contains(" Female") && (Education.contains(" High school graduate") || Education.contains(" 12th grade no diploma") || 
			    		 Education.contains(" 11th grade") || Education.contains(" Doctorate degree(PhD EdD)") ||
			    		 Education.contains(" Bachelors degree(BA AB BS)") || Education.contains(" Some college but no degree") 
			    		 || Education.contains(" Associates degree-academic program") || Education.contains(" Associates degree-occup /vocational")
			    		 || Education.contains(" Masters degree(MA MS MEng MEd MSW MBA)") || Education.contains(" Prof school degree (MD DDS DVM LLB JD)")
			    		 || Education.contains(" 10th grade"))) 
			     {
			    	 context.write(new Text("Educated Female :"), new IntWritable(1));
			     }
	  }
  }

  public static class eduReducer extends Reducer<Text,IntWritable,Text,IntWritable> 
  {
	  int unedfem = 0;
   	  int unedmal = 0;
   	  int edfem = 0;
   	  int edmal = 0;
   	  
    public void reduce(Text key, Iterable<IntWritable> values,Context context) throws IOException, InterruptedException 
    {    	 
      int count = 0;
      for (IntWritable val:values)
      {
    	  count += val.get();
    	  /*String str = val.toString();
    	  if(str.contains("UneduFemale"))
    	  {
    		  unedfem++;
    	  }
    	  if(str.contains("UneduMale"))
    	  {
    		  unedmal++;
    	  }
    	  if(str.contains("EducatedFemale"))
    	  {
    		  edfem++;
    	  }
    	  if(str.contains("EducatedMale"))
    	  {
    		  edmal++;
    	  }*/
      }
      context.write(key, new IntWritable(count));
     /* if(unedfem!=0)
      {
    	  context.write(new Text("No. of Uneducated Female : "), new Text(Integer.toString(unedfem)));  
      }
      if(edfem!=0)
      {
    	  context.write(new Text("No. of Educated Female : "), new Text(Integer.toString(edfem)));  
      }
      if(unedmal!=0)
      {
    	  context.write(new Text("No. of Uneducated Male : "), new Text(Integer.toString(unedmal)));  
      }
      
      if(edmal!=0)
      {
    	  context.write(new Text("No. of Educated Male : "), new Text(Integer.toString(edmal)));  
      } */     
    }
  }

  public static void main(String[] args) throws Exception {
    Configuration conf = new Configuration();
    //conf.set("mapred.textoutputformat.seperator","-");
    Job job = Job.getInstance(conf, "Education Census");
    job.setJarByClass(edu.class);
    job.setMapperClass(eduMapper.class);
    //job.setNumReduceTasks(0);
    job.setReducerClass(eduReducer.class);
    job.setOutputKeyClass(Text.class);
    job.setOutputValueClass(IntWritable.class);
    FileInputFormat.addInputPath(job, new Path(args[0]));
    FileOutputFormat.setOutputPath(job, new Path(args[1]));
    System.exit(job.waitForCompletion(true) ? 0 : 1);
  }
}
