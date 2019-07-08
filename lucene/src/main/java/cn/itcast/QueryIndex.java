package cn.itcast;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.File;
import java.io.IOException;

public class QueryIndex {

    @Test
    public void testSearch() throws Exception {
        Directory directory= FSDirectory.open(new File("F:\\lucene\\indexDir"));
        IndexReader indexReader = DirectoryReader.open(directory);
        IndexSearcher indexSearcher=new IndexSearcher(indexReader);
        QueryParser parser = new QueryParser("title", new IKAnalyzer());
        Query query = parser.parse("谷歌地图之父拉斯");
        TopDocs topDocs = indexSearcher.search(query, 10);
        System.out.println("本次搜索共找到" + topDocs.totalHits + "条数据");
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;
        for (ScoreDoc scoreDoc : scoreDocs) {
            int docId=scoreDoc.doc;
            Document doc=indexSearcher.doc(docId);
            System.out.println("id: " + doc.get("id"));
            System.out.println("title: " + doc.get("title"));
        }

    }
}
