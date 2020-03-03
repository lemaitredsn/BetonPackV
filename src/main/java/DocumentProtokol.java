import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DocumentProtokol {
    XWPFDocument documentP;
    DocumentQuality documentQuality;

    String SfieldNumberProtokol;
    String SfieldProizvod;
    String SfieldNameBetCH;
    String SfieldIzgotovKontrol;
    String SfieldNameMTR;
    String SfieldVozrast;
    String SfieldUSTverd;
    String SfieldUSIsp;
    String SfieldDateIzgot;
    String SfieldDateIsp;
    String SfieldKlassBet;
    String SfieldPlotnBet;
    String SfieldProchnB;
    String SfieldProchnBwithK;

    public XWPFDocument getDocument() {
        return documentP;
    }

    public DocumentProtokol(String SfieldNumberProtokol,
                            String SfieldDateProtokol,
                            String SfieldProizvod,
                            String SfieldNameBetCH,
                            String SfieldIzgotovKontrol,
                            String SfieldNameMTR,
                            String SfieldVozrast,
                            String SfieldUSTverd,
                            String SfieldUSIsp,
                            String SfieldDateIzgot,
                            String SfieldDateIsp,
                            String SfieldKlassBet,
                            String SfieldPlotnBet,
                            String SfieldProchnB,
                            String SfieldProchnBwithK) throws IOException, InvalidFormatException {
        documentP = new XWPFDocument();
        this.SfieldNumberProtokol = SfieldNumberProtokol;
        this.SfieldProizvod = SfieldProizvod;
        this.SfieldNameBetCH = SfieldNameBetCH;
        this.SfieldIzgotovKontrol = SfieldIzgotovKontrol;
        this.SfieldNameMTR = SfieldNameMTR;
        this.SfieldVozrast = SfieldVozrast;
        this.SfieldUSTverd = SfieldUSTverd;
        this.SfieldUSIsp = SfieldUSIsp;
        this.SfieldDateIzgot = SfieldDateIzgot;
        this.SfieldDateIsp = SfieldDateIsp;
        this.SfieldKlassBet = SfieldKlassBet;
        this.SfieldPlotnBet = SfieldPlotnBet;
        this.SfieldProchnB = SfieldProchnB;
        this.SfieldProchnBwithK = SfieldProchnB;

        XWPFParagraph paragraphLogo = documentP.createParagraph();
        XWPFRun logoRun = paragraphLogo.createRun();
        String pic = "logoIspit.JPG";
        int format = XWPFDocument.PICTURE_TYPE_JPEG;
        logoRun.addPicture(new FileInputStream(pic), format, pic, Units.toEMU(468.75), Units.toEMU(94.5));


        XWPFParagraph paragraph1 = documentP.createParagraph();
        paragraph1.setAlignment(ParagraphAlignment.CENTER);

        XWPFRun run1_1 = paragraph1.createRun();
        run1_1.setFontSize(12);
        run1_1.setFontFamily("Times New Roman");
        run1_1.setText("Строительная лаборатория");
        run1_1.setFontSize(14);
        run1_1.setFontFamily("Times New Roman");
        run1_1.setBold(true);
        run1_1.addBreak();

        XWPFRun run1_2 = paragraph1.createRun();
        run1_2.setFontSize(12);
        run1_2.setFontFamily("Times New Roman");
        run1_2.setText("Заключение №17 о состоянии измерений в лаборатории");
        run1_2.addBreak();
        run1_2.setText("выдано ФБУ \"Комсомольский ЦСМ\"");
        run1_2.addBreak();
        run1_2.setText("действительно до 28.06.2021г.");
        run1_2.addBreak();
        run1_2.addBreak();


        XWPFRun run1_3 = paragraph1.createRun();
        run1_3.setFontSize(12);
        run1_3.setFontFamily("Times New Roman");
        run1_3.setBold(true);
        run1_3.setText("Протокол испытания №" + SfieldNumberProtokol);
        run1_3.addBreak();
        run1_3.addBreak();

        XWPFRun run1_4 = paragraph1.createRun();
        run1_4.setFontSize(12);
        run1_4.setFontFamily("Times New Roman");
        run1_4.setText("Определение прочности бетона на сжатие");
        run1_4.addBreak();
        run1_4.addBreak();

        XWPFParagraph paragraph2 = documentP.createParagraph();
        paragraph2.setAlignment(ParagraphAlignment.LEFT);
        XWPFRun run2_1 = paragraph2.createRun();
        run2_1.setFontSize(12);
        run2_1.setFontFamily("Times New Roman");
        //Дата Протокола
        SfieldDateProtokol = SfieldDateIsp;
        run2_1.setText(SfieldDateProtokol + " г.");
        run2_1.addBreak();
        run2_1.addBreak();
        run2_1.setText("1. Производитель и поставщик: " + "ООО \"Аквамарин\";");
        run2_1.addBreak();
        run2_1.addBreak();
        run2_1.setText("2. Наименование бетонируемой части - объект: " + SfieldNameBetCH);
        run2_1.addBreak();
        run2_1.addBreak();
        run2_1.setText("3. Организация изготовитель контрольных образцов: " + SfieldIzgotovKontrol);
        run2_1.addBreak();
        run2_1.addBreak();
        run2_1.setText("4. Наименование материала, класс (марка): Бетон тяжелый" + SfieldNameMTR);
        run2_1.addBreak();
        run2_1.addBreak();
        run2_1.setText("5. Возраст контрольных образцов: " + SfieldVozrast);//тут поставить комбобокс на 7 или 14 суток
        run2_1.addBreak();
        run2_1.addBreak();
        run2_1.setText("6. Условия твердения: " + "Нормальные");
        run2_1.addBreak();
        run2_1.addBreak();
        run2_1.setText("Условия проведения испытания: " + "Температура воздуха + 20С, влажность 98%");
        run2_1.addBreak();
        run2_1.addBreak();


        XWPFParagraph paragraph3 = documentP.createParagraph();
        XWPFRun run3_1 = paragraph3.createRun();
        run3_1.setFontSize(12);
        run3_1.setFontFamily("Times New Roman");
        run3_1.setText("Средства измерений и испытательное оборудование: ");
        run3_1.addBreak();

        XWPFTable table = documentP.createTable();
        table.setCellMargins(10, 100, 10, 10);
        //create first row
        XWPFTableRow tableRowOne = table.getRow(0);
        tableRowOne.getCell(0).setText("№ п/п");
        tableRowOne.addNewTableCell().setText("Наименование средств измерения, оборудования");
        tableRowOne.addNewTableCell().setText("Марка");
        tableRowOne.addNewTableCell().setText("Заводской номер");
        tableRowOne.addNewTableCell().setText("Дата проверки, номер аттестата");
        //create second row
        XWPFTableRow tableRowTwo = table.createRow();
        tableRowTwo.getCell(0).setText("1");
        tableRowTwo.getCell(1).setText("Машина испытания на сжатие ИП-0");
        tableRowTwo.getCell(2).setText("ИП6083-500.0");
        tableRowTwo.getCell(3).setText("502");
        tableRowTwo.getCell(4).setText("08.11.2019г, №10058-19");
        XWPFTableRow tableRowThree = table.createRow();
        tableRowThree.getCell(0).setText("2");
        tableRowThree.getCell(1).setText("Весы электронные SUX");
        tableRowThree.getCell(2).setText("SUX 8200S");
        tableRowThree.getCell(3).setText("D453900040");
        tableRowThree.getCell(4).setText("06.07.2019г, №5180-19");
        XWPFTableRow tableRowFour = table.createRow();
        tableRowFour.getCell(0).setText("3");
        tableRowFour.getCell(1).setText("Линейка изм. Металлическая 500мм");
        tableRowFour.getCell(2).setText("-");
        tableRowFour.getCell(3).setText("Б/Н");
        tableRowFour.getCell(4).setText("03.07.2019г, №1104");

        run3_1.addBreak();


        XWPFParagraph paragraph4 = documentP.createParagraph();
        XWPFRun run4_1 = paragraph4.createRun();
        run4_1.setFontSize(12);
        run4_1.setFontFamily("Times New Roman");
        run4_1.setText("Отбор проб проводился согласно ГОСТ 10181 - 2000 \"Смеси" +
                " бетонные. Методы испытания\"");
        run4_1.addBreak();
        run4_1.setText("Оценка прочности контрольных образцов согласно ГОСТ 10180-2012" +
                "\"Бетоны. Метод определения прочности по контрольным образцам.\"");
        run4_1.addBreak();
        run4_1.addBreak();
        XWPFRun run4_2 = paragraph4.createRun();
        run4_2.setFontSize(12);
        run4_2.setFontFamily("Times New Roman");
        run4_2.setBold(true);
        run4_2.setText("Результаты испытаний");
        run4_2.addBreak();
        run4_2.addBreak();

        XWPFTable tableResult = documentP.createTable();
        tableResult.setCellMargins(10, 100, 10, 10);
        //create first row
        XWPFTableRow tableRowOneResult = tableResult.getRow(0);

        tableRowOneResult.getCell(0).setText("Дата изготовления");
        tableRowOneResult.addNewTableCell().setText("Дата испытания");
        tableRowOneResult.addNewTableCell().setText("Номер образца");
        tableRowOneResult.addNewTableCell().setText("Класс, марка бетона");
        tableRowOneResult.addNewTableCell().setText("Возраст, сутки");
        tableRowOneResult.addNewTableCell().setText("Плотность бетона, кн/м3" + SfieldPlotnBet);
        tableRowOneResult.addNewTableCell().setText("Прочность при сжатии, кг/см3" + SfieldProchnB);
        //create second row
        XWPFTableRow tableRowTwoResult = tableResult.createRow();

        /*
        (")Дата испытания" + SfieldDateIsp);
        ("Возраст, сутки" + SfieldVozrast);
        ("Возраст, сутки" + SfieldVozrast);
        ("Плотность бетона, кн/м3" + SfieldPlotnBet);
        ("Прочность при сжатии, кг/см3" + SfieldProchnB);
         */
        int plotn1 = (int) (Math.random() * 95 + 2400);
        int plotn2 = (int) (Math.random() * 95 + 2400);
        int plotn3 = (int) (Math.random() * 95 + 2400);
        int x1 = plotn1;
        int x2 = plotn2;
        int x3 = plotn3;
        int sr = (x1 + x2 + x3) / 3;
        SfieldKlassBet = SfieldNameMTR;

        tableRowTwoResult.getCell(0).setText(SfieldDateIzgot);
        tableRowTwoResult.getCell(1).setText(SfieldDateIsp);
        tableRowTwoResult.getCell(2).setText("1");
        tableRowTwoResult.getCell(3).setText(SfieldKlassBet);
        tableRowTwoResult.getCell(4).setText(SfieldVozrast);
        tableRowTwoResult.getCell(5).setText(String.valueOf(plotn1));
        tableRowTwoResult.getCell(6).setText("0000,6");
        XWPFTableRow tableRowThreeResult = tableResult.createRow();
        tableRowThreeResult.getCell(0).setText(SfieldDateIzgot);
        tableRowThreeResult.getCell(1).setText(SfieldDateIsp);
        tableRowThreeResult.getCell(2).setText("2");
        tableRowThreeResult.getCell(3).setText(SfieldKlassBet);
        tableRowThreeResult.getCell(4).setText(SfieldVozrast);
        tableRowThreeResult.getCell(5).setText(String.valueOf(plotn2));
        tableRowThreeResult.getCell(6).setText("0000,7");
        XWPFTableRow tableRowFourResult = tableResult.createRow();
        tableRowFourResult.getCell(0).setText(SfieldDateIzgot);
        tableRowFourResult.getCell(1).setText(SfieldDateIsp);
        tableRowFourResult.getCell(2).setText("3");
        tableRowFourResult.getCell(3).setText(SfieldKlassBet);
        tableRowFourResult.getCell(4).setText(SfieldVozrast);
        tableRowFourResult.getCell(5).setText(String.valueOf(plotn3));
        tableRowFourResult.getCell(6).setText("0000,8");

        XWPFParagraph paragraph5 = documentP.createParagraph();
        XWPFRun run5_1 = paragraph5.createRun();
        run5_1.setFontSize(12);
        run5_1.setFontFamily("Times New Roman");
        run5_1.addBreak();
        run5_1.setText("Среднее значение результатов испытаний:");
        run5_1.addBreak();
        run5_1.setText("Плотность в естественном состоянии:" + sr);
        run5_1.addBreak();
        run5_1.setText("Прочность при сжатии:" + "0000");
        run5_1.addBreak();
        run5_1.setText("Прочность при сжатии с учетом масштабного коэффициента согласно ГОСТ " +
                "10180-2012 составляет: " + SfieldProchnBwithK);
        run5_1.addBreak();
        run5_1.setText("Заключение: На основание результатов испытаний и требований ГОСТ 26633-2012 " +
                "\"Бетоны тяжелые и мелкозернистые. Технические условия\" фактическая прочность " +
                "на " + SfieldVozrast + " суток. Образцов кубов тяжелого бетона соответствует" + SfieldKlassBet + ".");
        run5_1.addBreak();
        run5_1.addBreak();
        run5_1.addBreak();
        run5_1.setText("Инженер-лаборант                   " + "Родя А.В.");

    }
}
