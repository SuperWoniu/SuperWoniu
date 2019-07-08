package cn.itcast;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.junit.Test;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class CreatIndex {
    @Test
    public void testCreat() throws Exception{
        Document document = new Document();
        document.add(new StringField("id","1", Field.Store.YES));
        document.add(new TextField("title","谷歌地图之父跳槽facebook", Field.Store.YES));
        document.add(new StoredField("url","http://www.jd.com/431"));
        Directory directory = FSDirectory.open(new File("F:\\lucene\\indexDir"));
        Analyzer analyzer = new IKAnalyzer();
        IndexWriterConfig config = new IndexWriterConfig(Version.LATEST,analyzer);
        config.setOpenMode(IndexWriterConfig.OpenMode.CREATE);

        IndexWriter indexWriter = new IndexWriter(directory, config);
        indexWriter.addDocument(document);
        indexWriter.commit();
        indexWriter.close();
    }

    @Test
    public void testCreate() throws IOException {
        // 创建文档的集合
        List<Document> docs;
        docs = new ArrayList<>();
        // 创建文档对象
        Document document1 = new Document();
        document1.add(new LongField("id", 1, Field.Store.YES));
        document1.add(new TextField("title", "谷歌地图之父跳槽facebook", Field.Store.YES));
        docs.add(document1);
        // 创建文档对象
        Document document2 = new Document();
        document2.add(new LongField("id", 2, Field.Store.YES));
        document2.add(new TextField("title", "谷歌地图之父加盟FaceBook", Field.Store.YES));
        docs.add(document2);
        // 创建文档对象
        Document document3 = new Document();
        document3.add(new LongField("id", 3, Field.Store.YES));
        document3.add(new TextField("title", "谷歌地图创始人拉斯离开谷歌加盟Facebook", Field.Store.YES));
        docs.add(document3);
        // 创建文档对象
        Document document4 = new Document();
        document4.add(new LongField("id", 4, Field.Store.YES));
        document4.add(new TextField("title", "谷歌地图之父跳槽Facebook与Wave项目取消有关", Field.Store.YES));
        docs.add(document4);
        // 创建文档对象
        Document document5 = new Document();
        document5.add(new LongField("id", 5, Field.Store.YES));
        document5.add(new TextField("title", "谷歌地图之父拉斯加盟社交网站Facebook", Field.Store.YES));
        docs.add(document5);

        Directory directory=FSDirectory.open(new File("F:\\lucene\\indexDir"));
        Analyzer analyzer = new IKAnalyzer();
        IndexWriterConfig config = new IndexWriterConfig(Version.LATEST,analyzer);
        config.setOpenMode(IndexWriterConfig.OpenMode.CREATE);

        IndexWriter indexWriter = new IndexWriter(directory, config);
        indexWriter.addDocuments(docs);
        indexWriter.commit();
        indexWriter.close();
    }
}
