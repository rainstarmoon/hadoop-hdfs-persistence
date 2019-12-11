package com.xiazeyu.hadoop.hdfs;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.LocatedFileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.RemoteIterator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HdfsApplicationTests {

    @Autowired
    private FileSystem fileSystem;

    @Test
    public void contextLoads() {
        try {
            RemoteIterator<LocatedFileStatus> locatedFileStatusRemoteIterator = fileSystem.listFiles(new Path("/"), true);
            while (locatedFileStatusRemoteIterator.hasNext()) {
                LocatedFileStatus next = locatedFileStatusRemoteIterator.next();
                System.out.println(next.getPath().toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
