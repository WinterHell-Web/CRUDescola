package com.adv.CRUDescola.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.adv.CRUDescola.model.AlunosModel;
import com.adv.CRUDescola.model.MatriculasModel;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfGeneratorReport 
{
    private PdfGeneratorReport() 
    {
        throw new IllegalStateException("Classe util");
    }

    public static ByteArrayInputStream alunosReport(AlunosModel aluno)
    {
        Document document = new Document(PageSize.A4.rotate());

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try
        {
            Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, Font.NORMAL);
            Font contentFont = FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL);

            PdfPTable tableHeader = new PdfPTable(3);
            tableHeader.setWidthPercentage(100);
            tableHeader.setWidths(new int[]{3, 3, 3});

            PdfPCell header;

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            header = new PdfPCell(new Phrase(dateFormat.format(new Date()), headFont));
            header.setVerticalAlignment(Element.ALIGN_TOP);
            header.setHorizontalAlignment(Element.ALIGN_LEFT);
            header.setBorderWidth(0);
            header.setPaddingBottom(15);
            tableHeader.addCell(header);

            header = new PdfPCell(new Phrase("Notas e faltas - " + aluno.getNome(), headFont));
            header.setVerticalAlignment(Element.ALIGN_TOP);
            header.setHorizontalAlignment(Element.ALIGN_CENTER);
            header.setBorderWidth(0);
            header.setPaddingBottom(15);
            tableHeader.addCell(header);

            header = new PdfPCell(new Phrase("FATEC Mogi das Cruzes", headFont));
            header.setVerticalAlignment(Element.ALIGN_TOP);
            header.setHorizontalAlignment(Element.ALIGN_RIGHT);
            header.setBorderWidth(0);
            header.setPaddingBottom(15);
            tableHeader.addCell(header);

            PdfPTable table = new PdfPTable(7);
            table.setWidthPercentage(100);
            table.setWidths(new int[]{3, 3, 1, 1, 2, 1, 2});

            PdfPCell hcell;

            hcell = new PdfPCell(new Phrase("Nome da matéria", headFont));
            hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            hcell.setBorderWidth(0);
            hcell.setBorderWidthBottom(2);
            hcell.setPaddingTop(7);
            hcell.setPaddingBottom(7);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Curso", headFont));
            hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            hcell.setBorderWidth(0);
            hcell.setBorderWidthBottom(2);
            hcell.setPaddingTop(7);
            hcell.setPaddingBottom(7);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Nota 1", headFont));
            hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            hcell.setBorderWidth(0);
            hcell.setBorderWidthBottom(2);
            hcell.setPaddingTop(7);
            hcell.setPaddingBottom(7);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Nota 2", headFont));
            hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            hcell.setBorderWidth(0);
            hcell.setBorderWidthBottom(2);
            hcell.setPaddingTop(7);
            hcell.setPaddingBottom(7);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Nota final", headFont));
            hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            hcell.setBorderWidth(0);
            hcell.setBorderWidthBottom(2);
            hcell.setPaddingTop(7);
            hcell.setPaddingBottom(7);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Faltas", headFont));
            hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            hcell.setBorderWidth(0);
            hcell.setBorderWidthBottom(2);
            hcell.setPaddingTop(7);
            hcell.setPaddingBottom(7);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Situação", headFont));
            hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            hcell.setBorderWidth(0);
            hcell.setBorderWidthBottom(2);
            hcell.setPaddingTop(7);
            hcell.setPaddingBottom(7);
            table.addCell(hcell);

            for (MatriculasModel matricula : aluno.getListMatricula())
            {
                PdfPCell cell;

                cell = new PdfPCell(new Phrase(matricula.getMateria().getNome(), contentFont));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell.setBorderWidth(0);
                cell.setBorderWidthTop(1);
                cell.setPaddingTop(7);
                cell.setPaddingBottom(7);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(matricula.getMateria().getCurso().getNome(), contentFont));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBorderWidth(0);
                cell.setBorderWidthTop(1);
                cell.setPaddingTop(7);
                cell.setPaddingBottom(7);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(matricula.getNota1().toString(), contentFont));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBorderWidth(0);
                cell.setBorderWidthTop(1);
                cell.setPaddingTop(7);
                cell.setPaddingBottom(7);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(matricula.getNota2().toString(), contentFont));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBorderWidth(0);
                cell.setBorderWidthTop(1);
                cell.setPaddingTop(7);
                cell.setPaddingBottom(7);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(String.valueOf(matricula.getNotaFinal()), contentFont));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBorderWidth(0);
                cell.setBorderWidthTop(1);
                cell.setPaddingTop(7);
                cell.setPaddingBottom(7);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(matricula.getFaltas().toString(), contentFont));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBorderWidth(0);
                cell.setBorderWidthTop(1);
                cell.setPaddingTop(7);
                cell.setPaddingBottom(7);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(matricula.getSituacao().getDescricao(), contentFont));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBorderWidth(0);
                cell.setBorderWidthTop(1);
                cell.setPaddingTop(7);
                cell.setPaddingBottom(7);
                table.addCell(cell);
            }
            
            PdfWriter.getInstance(document, out);

            document.open();
            document.addTitle("Notas e faltas - " + aluno.getNome());
            document.addAuthor("Sistema acadêmico para lançamento de notas (SALN)");

            document.add(tableHeader);
            document.add(table);
            document.close();
        }
        catch (DocumentException e)
        {
            System.out.println(e);
        }

        return new ByteArrayInputStream(out.toByteArray());
    }
}
