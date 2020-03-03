import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.FileInputStream;
import java.io.IOException;

public class DocumentQuality {
    XWPFDocument documentPass;
    String DocKach;
    String Potreb;
    String DataOtg;
    String VidBet;
    String Vbet;
    String MassDob;
    String MarkUd;
    String SohrUd;
    String Zapoln;
    String ProetvKlas;
    String Voz;
    String KoefVariacii;
    String Drugie;
    String NumSost;
    String dAktiv1;
    String dAktiv2;
    String dAktiv3;
    String NameMTR;
    String Morozostoyk;
    String Wodonepronicaem;

    public XWPFDocument getDocumentPass() {
        return documentPass;
    }

    public DocumentQuality(String DocKach, String Potreb, String DataOtg, String VidBet, String Vbet,
                           String MassDob, String MarkUd, String SohrUd,
                           String Zapoln, String ProetvKlas, String Voz, String KoefVariacii, String Drugie,
                           String NumSost, String dAktiv1,
                           String dAktiv2, String dAktiv3, String NameMTR,
                           String Morozostoyk,
                           String Wodonepronicaem) throws IOException, InvalidFormatException {
        this.DocKach = DocKach;
        this.Potreb = Potreb;
        this.DataOtg = DataOtg;
        this.VidBet = VidBet;
        this.Vbet = Vbet;
        this.MassDob = MassDob;
        this.MarkUd = MarkUd;
        this.SohrUd = SohrUd;
        this.Zapoln = Zapoln;
        this.ProetvKlas = ProetvKlas;
        this.Voz = Voz;
        this.KoefVariacii = KoefVariacii;
        this.Drugie = Drugie;
        this.NumSost = NumSost;
        this.dAktiv1 = dAktiv1;
        this.dAktiv2 = dAktiv2;
        this.dAktiv3 = dAktiv3;
        this.NameMTR = NameMTR;
        this.Morozostoyk = Morozostoyk;
        this.Wodonepronicaem = Wodonepronicaem;

        documentPass = new XWPFDocument();

        XWPFParagraph paragraphLogo = documentPass.createParagraph();
        XWPFRun logoRun = paragraphLogo.createRun();

        String pic = "logo.JPG";
        int format = XWPFDocument.PICTURE_TYPE_JPEG;
        logoRun.addPicture(new FileInputStream(pic), format, pic, Units.toEMU(492.75), Units.toEMU(131.25));
        logoRun.addBreak();

        XWPFParagraph paragraph = documentPass.createParagraph();
        XWPFRun run = paragraph.createRun();
        paragraph.setAlignment(ParagraphAlignment.CENTER);
        run.setText("Лаборатория");
        run.setFontSize(12);
        run.setFontFamily("Times New Roman");
        run.setBold(true);
        run.addBreak();


        XWPFRun run1_2 = paragraph.createRun();
        run1_2.setText("Заключение № 17 выдано 29.06.2018");
        run1_2.addBreak();
        run1_2.setText("\"ФБУ Комсомольским центром стандартизации, метрологии и сертификации\"");
        run1_2.setFontFamily("Times New Roman");
        run1_2.setFontSize(12);
        run1_2.addBreak();

        XWPFRun run1_3 = paragraph.createRun();
        run1_3.setText("ДОКУМЕНТ О КАЧЕСТВЕ БЕТОННОЙ СМЕСИ");
        run1_3.addBreak();
        run1_3.setText("ЗАДАННОГО КАЧЕСТВА ПАРТИИ №" + DocKach);
        run1_3.setFontSize(12);
        run1_3.setBold(true);
        run1_3.setFontFamily("Times New Roman");

        XWPFParagraph paragraph2 = documentPass.createParagraph();
        paragraph2.setSpacingBetween(1.3);
        XWPFRun run2_1 = paragraph2.createRun();
        run2_1.setFontSize(12);
        run2_1.setFontFamily("Times New Roman");
        run2_1.setText("Производитель и поставщик бетонной смеси: " + "ООО \"Аквамарин\";");
        run2_1.addBreak();

        run2_1.setText("Наименование, адрес, телефон: " + "г. Комсомольск-на-Амуре, ул. Чернышевского 5/2, 54-98-85;");
        run2_1.addBreak();
        run2_1.setText("Потребитель: " + Potreb + ",");
        run2_1.addBreak();
        run2_1.setText("Дата и время отгрузки бетонной смеси: " + DataOtg + ",");
        run2_1.addBreak();


        run2_1.setText("Вид бетонной смеси и ее условное обозначение: " +
                "Бетонная смесь тяжелого бетона БСТ " +
                " " + VidBet + ",");
        run2_1.addBreak();
        run2_1.setText("Номер состава бетонной смеси: " + NumSost + ",");
        run2_1.addBreak();
        run2_1.setText("Объем бетонной смеси в партии, м3: " + Vbet + ",");
        run2_1.addBreak();
        run2_1.setText("Марка бетонной смеси по удобоукладываемости: " + MarkUd + ",");
        run2_1.addBreak();
        run2_1.setText("Сохраняемость удобоукладываемости и других нормируемых показателей, ч-мин: " + SohrUd + ",");
        run2_1.addBreak();
        run2_1.setText("Наибольшая крупность заполнителя, мм " + Zapoln + ",");
        run2_1.addBreak();
        run2_1.setText("Проектный класс бетона по прочности и требуемая прочность бетона в партии: ");
        run2_1.addBreak();
        run2_1.setText("- в проектном возрасте: " + Voz + " суток" + ", " + ProetvKlas + " МПа;");
        run2_1.addBreak();
        run2_1.setText("Коэффициент вариации прочности бетона, %: " + KoefVariacii + ",");
        run2_1.addBreak();
        run2_1.setText("Другие нормируемые показатели качества бетона(при необходимости): " + Drugie + ",");
        run2_1.addBreak();
        run2_1.setText("Наименование масса добавки: " + MassDob + ",");
        run2_1.addBreak();
        run2_1.setText("Класс материалов по удельной эффективной активности естественных радионуклидов:");
        run2_1.addBreak();
        run2_1.setText("и значение АэффБк/кг: ");
        run2_1.addBreak();
        run2_1.setText("Цемент (ЦЕМ I42.5Н) ГОСТ31108-2016 - менее 47,16 Бк/кг " + dAktiv1 + ",");
        run2_1.addBreak();
        run2_1.setText("Щебень - 194,81 Бк/кг " + dAktiv2 + " б/н - 1 класс,");
        run2_1.addBreak();
        run2_1.setText("Песок - 112,3 Бк/кг " + dAktiv3 + " б/н - 1 класс.");
        run2_1.addBreak();
        run2_1.setText("Дата выдачи: " + DataOtg);
        run2_1.addBreak();
        run2_1.setText("Лаборант ООО \"Аквамарин\"                   Родя А.В.");
        run2_1.addBreak();

    }

}
