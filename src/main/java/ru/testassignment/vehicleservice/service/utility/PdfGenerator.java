package ru.testassignment.vehicleservice.service.utility;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;
import org.springframework.stereotype.Component;
import ru.testassignment.vehicleservice.dto.Pdf;

@Component
public class PdfGenerator {

  private static final Logger logger = LoggerFactory.getLogger(PdfGenerator.class);

  public static ByteArrayInputStream customerPDFReport(List<Pdf> pdfExport)
      throws DocumentException, IOException {
    Document document = new Document();
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    BaseFont times =
        BaseFont.createFont("c:/windows/fonts/times.ttf", "cp1251", BaseFont.EMBEDDED);

    try {

      PdfWriter.getInstance(document, out);
      document.open();

      // Add Text to PDF file ->
      Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14, BaseColor.BLACK);
      Paragraph para = new Paragraph("Vehicles Table", font);
      para.setAlignment(Element.ALIGN_CENTER);
      document.add(para);
      document.add(Chunk.NEWLINE);

      PdfPTable table = new PdfPTable(6);
      // Add PDF Table Header ->
      Stream.of("ID", "FirstName", "LastName", "Patronymic", "Brand", "Characteristics")
          .forEach(headerTitle -> {
            PdfPCell header = new PdfPCell();
            Font headFont = FontFactory.getFont(FontFactory.TIMES);
            header.setBackgroundColor(BaseColor.LIGHT_GRAY);
            header.setHorizontalAlignment(Element.ALIGN_CENTER);
            header.setBorderWidth(2);
            header.setPhrase(new Phrase(headerTitle, headFont));
            table.addCell(header);
          });

      for (Pdf pdf : pdfExport) {

        PdfPCell idCell = new PdfPCell(new Phrase(pdf.getId().toString()));
        idCell.setPaddingLeft(4);
        idCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        idCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(idCell);

        PdfPCell firstName = new PdfPCell(new Phrase(pdf.getFirst_name(), new Font(times)));
        firstName.setPaddingLeft(4);
        firstName.setVerticalAlignment(Element.ALIGN_MIDDLE);
        firstName.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(firstName);

        PdfPCell lastName = new PdfPCell(new Phrase(pdf.getLast_name(), new Font(times)));
        lastName.setVerticalAlignment(Element.ALIGN_MIDDLE);
        lastName.setHorizontalAlignment(Element.ALIGN_LEFT);
        lastName.setPaddingRight(4);
        table.addCell(lastName);

        PdfPCell patronymic = new PdfPCell(new Phrase(pdf.getPatronymic(), new Font(times)));
        patronymic.setVerticalAlignment(Element.ALIGN_MIDDLE);
        patronymic.setHorizontalAlignment(Element.ALIGN_LEFT);
        patronymic.setPaddingRight(4);
        table.addCell(patronymic);

        PdfPCell brand = new PdfPCell(new Phrase(pdf.getName()));
        brand.setVerticalAlignment(Element.ALIGN_MIDDLE);
        brand.setHorizontalAlignment(Element.ALIGN_LEFT);
        brand.setPaddingRight(4);
        table.addCell(brand);

        PdfPCell characteristics = new PdfPCell(
            new Phrase(pdf.getCharacteristics()));
        characteristics.setVerticalAlignment(Element.ALIGN_MIDDLE);
        characteristics.setHorizontalAlignment(Element.ALIGN_LEFT);
        characteristics.setPaddingRight(4);
        table.addCell(characteristics);
      }
      document.add(table);

      document.close();
    } catch (DocumentException e) {
      logger.error(e.toString());
    }

    return new ByteArrayInputStream(out.toByteArray());
  }
}
