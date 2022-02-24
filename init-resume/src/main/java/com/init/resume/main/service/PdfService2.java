package com.init.resume.main.service;

/*import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.BaseFont;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;*/

/*@Service*/

// 자바스크립트로 교체가능하면 후에 삭제
public class PdfService2 {

   /* private static final String PDF_RESOURCES = "/resources/";
    private DetailService detailService;
    private SpringTemplateEngine templateEngine;

    String fontPath ="/static/font/NanumGothicCoding.ttf";

    @Autowired
    public PdfService(DetailService detailService, SpringTemplateEngine templateEngine) {
        this.detailService = detailService;
        this.templateEngine = templateEngine;
    }

    public File generatePdf(int id) throws Exception {
        Context context = getContext(id);
        String html = loadAndFillTemplate(context);
        return renderPdf(html);
    }


    private File renderPdf(String html) throws IOException, DocumentException {
        
        File file = File.createTempFile("resume", ".pdf");
        OutputStream outputStream = new FileOutputStream(file);
        ITextRenderer renderer = new ITextRenderer(20f * 4f / 3f, 20);

        ITextFontResolver ifr =  renderer.getFontResolver(); // 한글로 나오게 할려면 필요하다
        ifr.addFont(fontPath, BaseFont.IDENTITY_H, true);
        renderer.setDocumentFromString(html, new ClassPathResource(PDF_RESOURCES).getURL().toExternalForm());
        renderer.layout();
        renderer.createPDF(outputStream);
        outputStream.close();
        file.deleteOnExit();
        return file;
    }

    private Context getContext(int id) throws Exception {
        Context context = new Context();
        context.setVariable("detail", detailService.getDetail(id));
        context.setVariable("work", detailService.workSelect(id));
        context.setVariable("career", detailService.careerSelect(id));
        context.setVariable("education", detailService.educationSelect(id));
        context.setVariable("edumatter", detailService.eduMatterSelect(id));
        context.setVariable("qualfi", detailService.qualifiSelect(id));
        context.setVariable("prize", detailService.prizeSelect(id));
        context.setVariable("img", detailService.imgSelect(id));
        return context;
    }

    private String loadAndFillTemplate(Context context) {
        return templateEngine.process("pdf-table", context);
    }
*/

}

