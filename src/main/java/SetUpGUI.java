import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class SetUpGUI {
    DocumentQuality documentQuality;
    DocumentProtokol documentProtokol;
    JFrame frame;
    JPanel panelQuality;
    JPanel panelProtokol;
    JTabbedPane tabbed;

    // todo комментарии считаются злом, отучайся их писать так как их хочется написать тогда, когда написал плохой код и приходится его обьяснять
    // В интернете должно быть полно информации по тому как это делать
    //ПРОТОКОЛ
    JButton buttonProtokol = new JButton("Сохранить и открыть");
    JTextField fieldDateProtokol = new JTextField("", 5);
    JTextField fieldProizvod = new JTextField("", 5);
    JLabel labelNameBetCh = new JLabel("Бетонируемая часть:");
    JTextArea fieldNameBetCH = new JTextArea(2, 30);
    JLabel labelVozrast = new JLabel("Возраст образцов");
    String[] comboBoxVozras = new String[]{
            "7",
            "28"
    };
    JComboBox comboBoxVozrast = new JComboBox(comboBoxVozras);
    JTextField fieldUSTverd = new JTextField("", 5);
    JTextField fieldUSIsp = new JTextField("", 5);
    JTextField fieldKlassBet = new JTextField("", 5);
    JTextField fieldPlotnBet = new JTextField("", 5);
    JTextField fieldProchnB = new JTextField("", 5);
    JTextField fieldProchnBwithK = new JTextField("", 5);

    //QUALITY
    JButton buttonQuality = new JButton("Сохранить и открыть");
    JTextField fieldDocKach = new JTextField("", 5);
    JLabel labelDocKach = new JLabel("№ документа о качестве");
    JLabel labelPotreb = new JLabel("Потребитель:");
    String[] company = {"ООО \"ПетроХэхуа\"",
            "ООО \"Газпром трансгаз Томск\"",
            "ООО \"ДВ ГазспецМонтаж\"",
            "Компания 1",
            "Компания 2",
            "Компания 3 ",
            "Компания 4"
    };
    JComboBox comboboxCompany = new JComboBox(company);
    JLabel labelDataOtg = new JLabel("Дата и время отгрузки бетонной смеси:");
    JTextField fieldDataOtg = new JTextField("", 5);
    JLabel labelnameDobavka = new JLabel("Наименование добавки: ");
    String[] StringNameDobavka = {
            "ПМД Криопласт",
            "ВСТ ВолосСидитТам",
            "СНВ СуньНосВон",
            ""
    };
    JComboBox comboBoxnameDobavka = new JComboBox(StringNameDobavka);
    JLabel labelBetonClassMarka = new JLabel("Класс, марка бетона: ");
    String[] BetonB = {
            "B3,5 M50",
            "B5 M75",
            "B7,5 M100",
            "B10 M150",
            "B12,5 M150",
            "B15 M200",
            "B20 M250",
            "B22,5 M300",
            "B25 M350",
            "B30 M400",
            "B35 M450",
            "B40 M550",
            "B45 M600",
            "B50 M600",
            "B55 M700",
            "B60 M800"
    };
    JComboBox comboBoxBetonClassMarka = new JComboBox(BetonB);
    JLabel labelBetonW = new JLabel("Водонепроницаемость, W: ");
    String[] BetonW = {
            "W4",
            "W5",
            "W6",
            "W7",
            "W8",
            "W9",
            "W10",
            ""
    };
    JComboBox comboBoxdBetonW = new JComboBox(BetonW);
    JLabel labelBetonF = new JLabel("Морозостойкость, F: ");
    String[] BetonF = {
            "F100",
            "F120",
            "F130",
            "F140",
            "F150",
            "F160",
            "F170",
            ""
    };
    JComboBox comboBoxdBetonF = new JComboBox(BetonF);
    JLabel labelVbet = new JLabel("Объем бетонной смеси в партии, м3 ");
    JTextField fieldVbet = new JTextField("", 5);
    JLabel labelMassDob = new JLabel("Масса добавки: ");
    JTextField fieldMassDob = new JTextField("", 5);
    JLabel labelAktiv1 = new JLabel("Класс материалов для цемента: Дата и номер");
    JTextField fieldAktiv1 = new JTextField("", 5);
    JLabel labelAktiv2 = new JLabel("Класс материалов для щебня: Дата и номер");
    JTextField fieldAktiv2 = new JTextField("", 5);
    JLabel labelAktiv3 = new JLabel("Класс материалов ля песка: Дата и номер");
    JTextField fieldAktiv3 = new JTextField("", 5);


    //todo Очень большой метод, надо его разбивать на логические части типо initContainer() initRow()
    //todo SetUpGUI с маленькой буквы
    public SetUpGUI() {
        frame = new JFrame("BetonPac");
        ImageIcon icon = new ImageIcon("src/main/resources/icon.png");
        frame.setIconImage(icon.getImage());
        frame.setVisible(true);
        frame.setBounds(100, 100, 620, 670);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panelProtokol = new JPanel();
        panelQuality = new JPanel();
        tabbed = new JTabbedPane();
        tabbed.add("Документ о качестве бетонной смеси", panelQuality);
        tabbed.add("Протокол испытания", panelProtokol);
        tabbed.setBackground(Color.YELLOW);
        tabbed.setForeground(Color.BLACK);
        //Шрифты
        Font font = new Font("Arial", Font.PLAIN, 16);
        Font fontForLabel = new Font("Arial", Font.PLAIN, 14);
        tabbed.setFont(font);
        // todo нарушил принцип DRY очень много где по проекту. Прочитай про него и везде где я напишу DRY попробуй исправить.
        // Тут тебе отвалю подсказку как это сделать: ставь шрифты в отдельном методе через цыкл, а не вручную https://stackoverflow.com/questions/12730230/set-the-same-font-for-all-component-java
        //Шрифты ПРОТОКОЛА
        labelNameBetCh.setFont(fontForLabel);
        fieldNameBetCH.setFont(fontForLabel);
        labelVozrast.setFont(fontForLabel);
        comboBoxVozrast.setFont(fontForLabel);
        buttonProtokol.setFont(fontForLabel);
        //Шрифты QUALITY
        labelDocKach.setFont(fontForLabel);
        fieldDocKach.setFont(fontForLabel);
        labelPotreb.setFont(fontForLabel);
        comboboxCompany.setFont(fontForLabel);
        labelDataOtg.setFont(fontForLabel);
        fieldDataOtg.setFont(fontForLabel);
        labelBetonClassMarka.setFont(fontForLabel);
        comboBoxBetonClassMarka.setFont(fontForLabel);
        labelBetonW.setFont(fontForLabel);
        comboBoxdBetonW.setFont(fontForLabel);
        labelBetonF.setFont(fontForLabel);
        comboBoxdBetonF.setFont(fontForLabel);
        labelnameDobavka.setFont(fontForLabel);
        comboBoxnameDobavka.setFont(fontForLabel);
        labelMassDob.setFont(fontForLabel);
        fieldMassDob.setFont(fontForLabel);
        labelVbet.setFont(fontForLabel);
        fieldVbet.setFont(fontForLabel);
        labelAktiv1.setFont(fontForLabel);
        fieldAktiv1.setFont(fontForLabel);
        labelAktiv2.setFont(fontForLabel);
        fieldAktiv2.setFont(fontForLabel);
        labelAktiv3.setFont(fontForLabel);
        fieldAktiv3.setFont(fontForLabel);
        buttonQuality.setFont(fontForLabel);
        //УСТАНОВКА ТАБ
        frame.add(tabbed);
        //ПРОТОКОЛ
        labelNameBetCh.setFont(fontForLabel);
        fieldNameBetCH.setFont(fontForLabel);
        labelVozrast.setFont(fontForLabel);
        comboBoxVozrast.setFont(fontForLabel);
        buttonProtokol.setFont(fontForLabel);
        panelProtokol.setLayout(new GridBagLayout());
        // todo DRY
        panelProtokol.add(labelNameBetCh, new GridBagConstraints(1, 1, 1, 1, 0, 0,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(10, 2, 10, 2), 0, 0));

        panelProtokol.add(fieldNameBetCH, new GridBagConstraints(2, 1, 1, 1, 0, 0,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(10, 2, 10, 2), 0, 0));

        panelProtokol.add(labelVozrast, new GridBagConstraints(1, 2, 1, 1, 0, 0,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(10, 2, 10, 2), 0, 0));

        panelProtokol.add(comboBoxVozrast, new GridBagConstraints(2, 2, 1, 1, 0, 0,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(10, 2, 10, 2), 0, 0));

        panelProtokol.add(buttonProtokol, new GridBagConstraints(1, 3, 1, 1, 0, 0,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(10, 2, 10, 2), 0, 0));
        buttonProtokol.addActionListener(new ButtonProtokolEventListener());


        //Quality GUI
        panelQuality.setLayout(new GridBagLayout());

        // todo DRY
        panelQuality.add(labelDocKach, new GridBagConstraints(1, 1, 1, 1, 0, 0,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(5, 2, 5, 2), 0, 10));
        panelQuality.add(fieldDocKach, new GridBagConstraints(2, 1, 1, 1, 0, 0,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(5, 2, 5, 2), 0, 10));
        panelQuality.add(labelPotreb, new GridBagConstraints(1, 2, 1, 1, 0, 0,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(5, 2, 5, 2), 0, 10));
        panelQuality.add(comboboxCompany, new GridBagConstraints(2, 2, 1, 1, 0, 0,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(5, 2, 5, 2), 0, 10));
        panelQuality.add(labelDataOtg, new GridBagConstraints(1, 3, 1, 1, 0, 0,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(5, 2, 5, 2), 0, 10));
        panelQuality.add(fieldDataOtg, new GridBagConstraints(2, 3, 1, 1, 0, 0,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(5, 2, 5, 2), 0, 10));
        panelQuality.add(labelBetonClassMarka, new GridBagConstraints(1, 4, 1, 1, 0, 0,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(5, 2, 5, 2), 0, 10));
        panelQuality.add(comboBoxBetonClassMarka, new GridBagConstraints(2, 4, 1, 1, 0, 0,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(5, 2, 5, 2), 0, 10));
        panelQuality.add(labelBetonW, new GridBagConstraints(1, 5, 1, 1, 0, 0,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(5, 2, 5, 2), 0, 10));
        panelQuality.add(comboBoxdBetonW, new GridBagConstraints(2, 5, 1, 1, 0, 0,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(5, 2, 5, 2), 0, 10));
        panelQuality.add(labelBetonF, new GridBagConstraints(1, 6, 1, 1, 0, 0,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(5, 2, 5, 2), 0, 10));
        panelQuality.add(comboBoxdBetonF, new GridBagConstraints(2, 6, 1, 1, 0, 0,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(5, 2, 5, 2), 0, 10));
        panelQuality.add(labelnameDobavka, new GridBagConstraints(1, 7, 1, 1, 0, 0,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(5, 2, 5, 2), 0, 10));
        panelQuality.add(comboBoxnameDobavka, new GridBagConstraints(2, 7, 1, 1, 0, 0,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(5, 2, 5, 2), 0, 10));
        panelQuality.add(labelMassDob, new GridBagConstraints(1, 8, 1, 1, 0, 0,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(5, 2, 5, 2), 0, 10));
        panelQuality.add(fieldMassDob, new GridBagConstraints(2, 8, 1, 1, 0, 0,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(5, 2, 5, 2), 0, 10));
        panelQuality.add(labelVbet, new GridBagConstraints(1, 9, 1, 1, 0, 0,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(5, 2, 5, 2), 0, 10));
        panelQuality.add(fieldVbet, new GridBagConstraints(2, 9, 1, 1, 0, 0,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(5, 2, 5, 2), 0, 10));
        panelQuality.add(labelAktiv1, new GridBagConstraints(1, 10, 1, 1, 0, 0,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(5, 2, 5, 2), 0, 10));
        panelQuality.add(fieldAktiv1, new GridBagConstraints(2, 10, 1, 1, 0, 0,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(5, 2, 5, 2), 0, 10));
        panelQuality.add(labelAktiv2, new GridBagConstraints(1, 11, 1, 1, 0, 0,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(5, 2, 5, 2), 0, 10));
        panelQuality.add(fieldAktiv2, new GridBagConstraints(2, 11, 1, 1, 0, 0,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(5, 2, 5, 2), 0, 10));
        panelQuality.add(labelAktiv3, new GridBagConstraints(1, 12, 1, 1, 0, 0,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(5, 2, 5, 2), 0, 10));
        panelQuality.add(fieldAktiv3, new GridBagConstraints(2, 12, 1, 1, 0, 0,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(10, 2, 10, 2), 0, 10));
        buttonQuality.addActionListener(new ButtonEventListenerQuality());
        panelQuality.add(buttonQuality, new GridBagConstraints(1, 13, 1, 1, 0, 0,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(5, 2, 5, 2), 0, 10));
        comboboxCompany.setEditable(true);
        readStrings();
    }

    void goToWordProtokol(DocumentProtokol documentProtokol) {
        File file = new File("protokol.docx");
        try {
            FileOutputStream output = new FileOutputStream(file);
            documentProtokol.getDocument().write(output);
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Desktop desktop = Desktop.getDesktop();
        try {
            desktop.open(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class ButtonProtokolEventListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            // todo Что это за префикс S? переменные должны быть с маленькой буквы и забудь про префиксы, от них везде отказались
            // todo Вынести в метод getProtokol()
            String SfieldNumberProtokol = fieldDataOtg.getText().replace(".", "") + " - "
                    + fieldDocKach.getText() + "/" + comboBoxVozrast.getSelectedItem();
            String SfieldDateProtokol = fieldDateProtokol.getText();
            String SfieldProizvod = fieldProizvod.getText();
            String SfieldNameBetCH = fieldNameBetCH.getText();
            String SfieldIzgotovKontrol = (String) comboboxCompany.getSelectedItem();
            String SfieldNameMTR = " " + comboBoxBetonClassMarka.getSelectedItem() + " " +
                    comboBoxdBetonF.getSelectedItem() + " " + comboBoxdBetonW.getSelectedItem();
            String SfieldVozrast = (String) comboBoxVozrast.getSelectedItem();
            String SfieldUSTverd = fieldUSTverd.getText();
            String SfieldUSIsp = fieldUSIsp.getText();
            String SfieldDateIzgot = fieldDataOtg.getText();
            String SfieldDateIsp = null;
            try {
                // todo создать getDate() и туда запихать все это вместе с траем кэтчем
                SfieldDateIsp = datetoString(getDateIspitaniya(stringToDate(SfieldDateIzgot), SfieldVozrast));
            } catch (Exception e) {
                e.printStackTrace();
            }
            String SfieldKlassBet = fieldKlassBet.getText();
            String SfieldPlotnBet = fieldPlotnBet.getText();
            String SfieldProchnB = fieldProchnB.getText();
            String SfieldProchnBwithK = fieldProchnBwithK.getText();

            try {
                documentProtokol = new DocumentProtokol(SfieldNumberProtokol, SfieldDateProtokol, SfieldProizvod, SfieldNameBetCH,
                        SfieldIzgotovKontrol,
                        SfieldNameMTR, SfieldVozrast, SfieldUSTverd, SfieldUSIsp, SfieldDateIzgot, SfieldDateIsp,
                        SfieldKlassBet,
                        SfieldPlotnBet, SfieldProchnB, SfieldProchnBwithK);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InvalidFormatException e) {
                e.printStackTrace();
            }
            goToWordProtokol(documentProtokol);
        }
    }

    class ButtonEventListenerQuality implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            // todo все переменные с маленькой буквы
            String DocKach = fieldDataOtg.getText().replace(".", "") + " - " + fieldDocKach.getText();
            String Potreb = (String) comboboxCompany.getSelectedItem();
            String DataOtg = fieldDataOtg.getText();
            String nameDobavka;
            String strnameDob = (String) comboBoxnameDobavka.getSelectedItem();
            if (strnameDob.equals("ПМД Криопласт")) {
                nameDobavka = " с ПМД ГОСТ 7473 - 2010";
            }
            /*else if (strnameDob.equals("ВСТ ВолосСидитТам")) {
                nameDobavka = " c ВСТ ГОСТ 000000000";
            } else if (strnameDob.equals("СНВ СуньНосВон")) {
                nameDobavka = " c СНВ ГОСТ 000000000";
            }*/
            else nameDobavka = "";
            String VidBet = " " + comboBoxBetonClassMarka.getSelectedItem() + " " + comboBoxdBetonF.getSelectedItem() +
                    " " + comboBoxdBetonW.getSelectedItem() + nameDobavka;
            String Vbet = fieldVbet.getText();
            String MassDob = (String) comboBoxnameDobavka.getSelectedItem() + " - " + fieldMassDob.getText() + "кг";
            String strComboBoxBetonCM = (String) comboBoxBetonClassMarka.getSelectedItem();
            String[] arrayBetonMK = getDataBeton(strComboBoxBetonCM);
            // todo ты вот подписал все, а можешь просто сделать enam c этими значениями и хэшмап вместо массива в которой ключем будет значения из энама. А потом делать так betonMK.get(P4), betonMK.get(5_20)
            String MarkUd = arrayBetonMK[0];//П4
            String SohrUd = arrayBetonMK[1];//5-20
            String Zapoln = arrayBetonMK[2];//20
            String Voz = arrayBetonMK[3];//28
            String ProetvKlas = arrayBetonMK[4];//32,7
            String KoefVariacii = arrayBetonMK[5];//5,19
            String Drugie = arrayBetonMK[6];//0,56
            String NumSost = arrayBetonMK[7];//101
            String dAktiv1 = fieldAktiv1.getText();
            String dAktiv2 = fieldAktiv2.getText();
            String dAktiv3 = fieldAktiv3.getText();
            saveStrings(dAktiv1, dAktiv2, dAktiv3);


            String NameMTR = strComboBoxBetonCM;
            String Morozostoyk = (String) comboBoxdBetonW.getSelectedItem();
            String Wodonepronicaem = (String) comboBoxdBetonF.getSelectedItem();

            try {
                documentQuality = new DocumentQuality(DocKach, Potreb, DataOtg, VidBet, Vbet, MassDob, MarkUd,
                        SohrUd,
                        Zapoln, ProetvKlas, Voz, Drugie, KoefVariacii, NumSost, dAktiv1, dAktiv2, dAktiv3,
                        NameMTR,
                        Morozostoyk,
                        Wodonepronicaem);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InvalidFormatException e) {
                e.printStackTrace();
            }
            goToWordPassport(documentQuality);
        }
    }


    String generateNameFile() {
        Date d = new Date();
        String date = String.format("%1$tH%1$tM%1$tS", d);
        String nameFile;
        nameFile = (String) comboboxCompany.getSelectedItem() + fieldDataOtg.getText() + date;
        String nameFileFinal = nameFile.replaceAll("[^а-яА-ЯёЁa-zA-Z0-9]", "") + ".doc";
        return nameFileFinal;
    }


    public String[] getDataBeton(String str) {
        String BetonString[] = new String[8];
        if(str.equals("B3,5 M50")){
            // todo зачем все это ветвение если результат всегда один?
            BetonString = new String[]{"П4", "5-20", "20", "28", "32,7", "0,56", "5,19", "101"};
        }else if (str.equals("B5 M75")) {
            BetonString = new String[]{"П4", "5-20", "20", "28", "32,7", "0,56", "5,19", "101"};
        }else if (str.equals("B7,5 M100")) {
            BetonString = new String[]{"П4", "5-20", "20", "28", "32,7", "0,56", "5,19", "101"};
        } else if (str.equals("B10 M150")) {
            BetonString = new String[]{"П4", "5-20", "20", "28", "32,7", "0,56", "5,19", "101"};
        }else if (str.equals("B12,5 M150")) {
            BetonString = new String[]{"П4", "5-20", "20", "28", "32,7", "0,56", "5,19", "101"};
        } else if (str.equals("B15 M200")) {
            BetonString = new String[]{"П4", "5-20", "20", "28", "32,7", "0,56", "5,19", "101"};
        } else if (str.equals("B20 M250")) {
            BetonString = new String[]{"П4", "5-20", "20", "28", "32,7", "0,56", "5,19", "101"};
        }else if (str.equals("B22,5 M300")) {
            BetonString = new String[]{"П4", "5-20", "20", "28", "32,7", "0,56", "5,19", "101"};
        } else if (str.equals("B25 M350")) {
            BetonString = new String[]{"П4", "5-20", "20", "28", "32,7", "0,56", "5,19", "101"};
        } else if (str.equals("B30 M400")) {
            BetonString = new String[]{"П4", "5-20", "20", "28", "32,7", "0,56", "5,19", "101"};
        }else if (str.equals("B35 M450")) {
            BetonString = new String[]{"П4", "5-20", "20", "28", "32,7", "0,56", "5,19", "101"};
        } else if (str.equals("В40 M550")) {
            BetonString = new String[]{"П4", "5-20", "20", "28", "32,7", "0,56", "5,19", "101"};
        }else if (str.equals("B45 M600")) {
            BetonString = new String[]{"П4", "5-20", "20", "28", "32,7", "0,56", "5,19", "101"};
        }else if (str.equals("B50 M600")) {
            BetonString = new String[]{"П4", "5-20", "20", "28", "32,7", "0,56", "5,19", "101"};
        }else if (str.equals("B55 M700")) {
            BetonString = new String[]{"П4", "5-20", "20", "28", "32,7", "0,56", "5,19", "101"};
        }else if (str.equals("B60 M800")) {
            BetonString = new String[]{"П4", "5-20", "20", "28", "32,7", "0,56", "5,19", "101"};
        }
        return BetonString;
    }


    void goToWordPassport(DocumentQuality documentQuality) {

        String name = generateNameFile();
        File file = new File(name);
        try {
            FileOutputStream output = new FileOutputStream(file);
            documentQuality.getDocumentPass().write(output);
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Desktop desktop = Desktop.getDesktop();
        try {
            desktop.open(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public LocalDate stringToDate(String string) throws Exception {
        // todo зачем ты создаешь все эти локальные переменные? По чему ты не можешь использовать string на прямую
        String str = string;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate dateTime = LocalDate.parse(str, formatter);
        return dateTime;
    }

    // todo Ставить наименьшую область(модификатор, тут private) видимости всегда и всем
    public LocalDate getDateIspitaniya(LocalDate date, String Sutok) {
        LocalDate d = date;
        String s = Sutok;
        long vozrast = Long.parseLong(s);
        return d.plusDays(vozrast);
    }


    public String datetoString(LocalDate Date) {
        LocalDate d = Date;
        String str = d.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return str;
    }

    public void saveStrings(String str1, String str2, String str3){
        try {
            //тут записываем в файл!!!
            FileWriter writer = new FileWriter("Foo.txt");
            writer.write(str1 + "\n");
            writer.write(str2 + "\n");
            writer.write(str3);
            writer.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void readStrings(){
        try {
            //Отсюда мы считываем
            File myFile = new File("Foo.txt");
            FileReader fileReader = new FileReader(myFile);

            BufferedReader reader = new BufferedReader(fileReader);
            String line = null;
            ArrayList<String> lines = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            if(lines == null){
                lines.add(0,"");
                lines.add(1,"");
                lines.add(2,"");
            }

            fieldAktiv1.setText(lines.get(0));
            fieldAktiv2.setText(lines.get(1));
            fieldAktiv3.setText(lines.get(2));

            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
