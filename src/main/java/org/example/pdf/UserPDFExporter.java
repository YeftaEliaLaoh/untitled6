package org.example.pdf;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import org.example.models.Users;


public class UserPDFExporter {
    private List<Users> listUsers;

    public UserPDFExporter(List<Users> listUsers) {
        this.listUsers = listUsers;
    }

    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setNoWrap(false);
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);

        cell.setPhrase(new Phrase("No.", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Login", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Avatar Url", font));
        table.addCell(cell);;
        cell.setPhrase(new Phrase("Url", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Html Url", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Gists Url", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Repos Url", font));
        table.addCell(cell);
    }

    private void writeTableData(PdfPTable table) {
        int i = 1;
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setSize(10);
        PdfPCell cell = new PdfPCell();
        for (Users user : listUsers) {
            cell.setPhrase(new Phrase(String.valueOf(i++), font));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
            cell.setPhrase(new Phrase(user.getLogin(), font));
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(cell);
            cell.setPhrase(new Phrase(user.getAvatar_url(), font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(user.getUrl(), font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(user.getHtml_url(), font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(user.getGists_url(), font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(user.getRepos_url(), font));
            table.addCell(cell);
        }
    }

    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);

        Paragraph p = new Paragraph("List of Users", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(p);

        PdfPTable table = new PdfPTable(7);
        table.setWidthPercentage(100f);
        table.setWidths(new float[]{1.5f, 2.5f, 3.0f, 3.5f, 3.5f, 3.5f, 3.5f
        });
        table.setSpacingBefore(5);

        writeTableHeader(table);
        writeTableData(table);

        document.add(table);
        document.close();

    }
}
