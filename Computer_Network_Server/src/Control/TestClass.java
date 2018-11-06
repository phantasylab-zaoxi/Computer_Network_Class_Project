package Control;

import Former.HttpFormer;
import HTTPHeader.*;
import Helper.FileReader;

public class TestClass {
    public static void main(String[] args)
    {
        // How to make http response
        ResponseHttp res = new ResponseHttp(ResponseHttp.StatusCode.OK);
        HttpFormer httpformer = new HttpFormer(res);

        AcceptRangeHeader rangeHeader = new AcceptRangeHeader(AcceptRangeHeader.RangeType.bytes);
        httpformer.AddHeaderField(rangeHeader);

        KeepAliveHeader keepAliveHeader = new KeepAliveHeader(5, 100);
        httpformer.AddHeaderField(keepAliveHeader);

        ContentTypeHeader contentTypeHeader = new ContentTypeHeader(ContentTypeHeader.ContentType.text_html, ContentTypeHeader.CharType.utf_8);
        httpformer.AddHeaderField(contentTypeHeader);
        System.out.println(httpformer.toString());

        // How to analyze http request
        RequestHttp req = new RequestHttp("GET /index/index.html HTTP/1.1\r\nHost: 127.0.0.1\r\nUser-Agent:Firefox/3.6.10\r\n\r\nAssdead");
        System.out.println(req.GetPathName());


        //파일리더 테스트
        FileReader fileReader = new FileReader("C:\\Users\\heoyouseong\\Desktop\\까치");

        //수정시간 출력 테스트
        System.out.println(fileReader.GetLastModifiedDate("test.txt"));

        //바이트 출력 테스트
        System.out.println(fileReader.GetFileLength("test.txt"));


        //폴더 내 리스트 출력 테스트
        for(String data : fileReader.GetAllContents()) {
            System.out.println(data);
        }



    }
}
