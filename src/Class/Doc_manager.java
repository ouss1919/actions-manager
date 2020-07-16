package Class;

import javafx.collections.ObservableList;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.sql.*;
import java.util.Iterator;

public class Doc_manager {
    private static final String FILE_NAME = "C:/Users/" + System.getProperty("user.name") + "/Desktop/import.xlsx";

    public static Personnel xlsx_row_to_personnal(Row row){
        if(row.getLastCellNum()>0){
            Personnel personnel = new Personnel();
            if(row.getCell(0)!= null)
                if(row.getCell(0).getCellType() == CellType.NUMERIC){
                    personnel.setId(Integer.toString((int)row.getCell(0).getNumericCellValue()));
                }
                else {
                    personnel.setId(row.getCell(0).getStringCellValue());
                }
            if(row.getCell(1)!= null)
                if(row.getCell(1).getCellType() == CellType.NUMERIC){
                    personnel.setNom(Integer.toString((int)row.getCell(1).getNumericCellValue()));
                }
                else {
                    personnel.setNom(row.getCell(1).getStringCellValue());
                }
            if(row.getCell(2)!= null)
                if(row.getCell(2).getCellType() == CellType.NUMERIC){
                    personnel.setPrenom(Integer.toString((int)row.getCell(2).getNumericCellValue()));
                }
                else {
                    personnel.setPrenom(row.getCell(2).getStringCellValue());
                }
            if(row.getCell(3)!= null)
            {
                java.util.Date value = row.getCell(3).getDateCellValue();
                System.out.println(value);
                if(value!=null){
                    Date date = new Date(value.getTime());
                    System.out.println(date);
                    personnel.setDate_dentree(date);
                }
            }
            if(row.getCell(4)!= null)
                if(row.getCell(4).getCellType() == CellType.NUMERIC){
                    personnel.setPoste(Integer.toString((int)row.getCell(4).getNumericCellValue()));
                }
                else {
                    personnel.setPoste(row.getCell(4).getStringCellValue());
                }
            if(row.getCell(5)!= null)
                if(row.getCell(5).getCellType() == CellType.NUMERIC){
                    personnel.setType_demploi(Integer.toString((int)row.getCell(5).getNumericCellValue()));
                }
                else {
                    personnel.setType_demploi(row.getCell(5).getStringCellValue());
                }
            if(row.getCell(6)!= null)
                if(row.getCell(6).getCellType() == CellType.NUMERIC){
                    personnel.setCategorie(Integer.toString((int)row.getCell(6).getNumericCellValue()));
                }
                else {
                    personnel.setCategorie(row.getCell(6).getStringCellValue());
                }
            if(row.getCell(7)!= null)
                if(row.getCell(7).getCellType() == CellType.NUMERIC){
                    personnel.setDirection(Integer.toString((int)row.getCell(7).getNumericCellValue()));
                }
                else {
                    personnel.setDirection(row.getCell(7).getStringCellValue());
                }
            if(row.getCell(8) != null)
                if(row.getCell(8).getCellType() == CellType.NUMERIC){
                    personnel.setDepartement(Integer.toString((int)row.getCell(8).getNumericCellValue()));
                }
                else {
                    personnel.setDepartement(row.getCell(8).getStringCellValue());
                }
            if(row.getCell(9) != null)
                if(row.getCell(9).getCellType() == CellType.NUMERIC){
                    personnel.setService(Integer.toString((int)row.getCell(9).getNumericCellValue()));
                }
                else {
                    personnel.setService(row.getCell(9).getStringCellValue());
                }
            return personnel;
        }
        else
            return null;
    }

    public static Action xlsx_row_to_action(Row row){
        if(row.getLastCellNum()>0){
            Action action = new Action();
            if(row.getCell(0)!= null)
                action.setNum((int)row.getCell(0).getNumericCellValue());
            if(row.getCell(1)!= null)
                if(row.getCell(1).getCellType() == CellType.NUMERIC){
                    action.setAct(Integer.toString((int)row.getCell(1).getNumericCellValue()));
                }
                else {
                    action.setAct(row.getCell(1).getStringCellValue());
                }
            if(row.getCell(2)!= null)
                if(row.getCell(2).getCellType() == CellType.NUMERIC){
                    action.setObj_rech(Integer.toString((int)row.getCell(2).getNumericCellValue()));
                }
                else {
                    action.setObj_rech(row.getCell(2).getStringCellValue());
                }
            if(row.getCell(3)!= null)
                if(row.getCell(3).getCellType() == CellType.NUMERIC){
                    action.setStructure(Integer.toString((int)row.getCell(3).getNumericCellValue()));
                }
                else {
                    action.setStructure(row.getCell(3).getStringCellValue());
                }
            if(row.getCell(4)!= null)
                action.setEff_real_forme((int)row.getCell(4).getNumericCellValue());
            if(row.getCell(5)!= null)
                action.setNbr_participants((int)row.getCell(5).getNumericCellValue());
            if(row.getCell(6)!= null)
                action.setDuree_jour((int)row.getCell(6).getNumericCellValue());
            if(row.getCell(7)!= null)
            {
                java.util.Date value = row.getCell(7).getDateCellValue();
                System.out.println(value);
                if(value!=null){
                    Date date = new Date(value.getTime());
                    System.out.println(date);
                    action.setDebut_formation(date);
                }
            }
            if(row.getCell(8)!= null)
                action.setCout((int)row.getCell(8).getNumericCellValue());
            if(row.getCell(9)!= null)
                if(row.getCell(9).getCellType() == CellType.NUMERIC){
                    action.setOrganisme_formation(Integer.toString((int)row.getCell(9).getNumericCellValue()));
                }
                else {
                    action.setOrganisme_formation(row.getCell(9).getStringCellValue());
                }
            if(row.getCell(10)!= null)
                if(row.getCell(10).getCellType() == CellType.NUMERIC){
                    action.setLieu_formation(Integer.toString((int)row.getCell(10).getNumericCellValue()));
                }
                else {
                    action.setLieu_formation(row.getCell(10).getStringCellValue());
                }
            if(row.getCell(11)!= null)
                if(row.getCell(11).getCellType() == CellType.NUMERIC){
                    action.setPeriode_devaluation(Integer.toString((int)row.getCell(11).getNumericCellValue()));
                }
                else {
                    action.setPeriode_devaluation(row.getCell(11).getStringCellValue());
                }
            return action;
        }
        else
            return null;
    }

    public static void importer_xlsx(File file) {
        try {
            if(file!=null){
                FileInputStream excelFile = new FileInputStream(file);
                System.out.println(file.getAbsolutePath());
                Workbook classeur = new XSSFWorkbook(excelFile);
                Sheet feuille = classeur.getSheetAt(0);
                Iterator<Row> rowIterator = feuille.iterator();
                Row currentRow = rowIterator.next();
                currentRow = rowIterator.next();
                while (rowIterator.hasNext()) {

                    currentRow = rowIterator.next();
                    Operateur.ajouter_personnel(Doc_manager.xlsx_row_to_personnal(currentRow));
                    //Iterator<Cell> cellIterator = currentRow.iterator();
                    //Operateur.ajouter_personnel(Doc_manager.xlsx_line_to_personnal(cellIterator));

                }
                feuille = classeur.getSheetAt(1);
                rowIterator = feuille.iterator();
                currentRow = rowIterator.next();
                currentRow = rowIterator.next();
                while (rowIterator.hasNext()) {

                    currentRow = rowIterator.next();
                    Operateur.ajouter_action(Doc_manager.xlsx_row_to_action(currentRow),"actions_planif");
                    //Iterator<Cell> cellIterator = currentRow.iterator();
                    //Operateur.ajouter_action(Doc_manager.xlsx_line_to_action(cellIterator),"actions_planif");

                }
                feuille = classeur.getSheetAt(2);
                rowIterator = feuille.iterator();
                currentRow = rowIterator.next();
                currentRow = rowIterator.next();
                while (rowIterator.hasNext()) {

                    currentRow = rowIterator.next();
                    Operateur.ajouter_action(Doc_manager.xlsx_row_to_action(currentRow),"actions_non_planif");
                    //Iterator<Cell> cellIterator = currentRow.iterator();
                    //Operateur.ajouter_action(Doc_manager.xlsx_line_to_action(cellIterator),"actions_non_planif");

                }
            }
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }


    }

    public static void exporter_xlsx_personnel(File file,ObservableList<Personnel> data) {
        if(file!=null){
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("personnel");
            CreationHelper createHelper = workbook.getCreationHelper();
            int rowNum = 0;
            for (int i=0;i<data.size();i++) {
                Row row = sheet.createRow(rowNum++);
                Personnel personnel = data.get(i);
                int colNum = 0;
                Cell cell = row.createCell(colNum++);
                cell.setCellValue(personnel.getId());
                cell = row.createCell(colNum++);
                cell.setCellValue(personnel.getNom());
                cell = row.createCell(colNum++);
                cell.setCellValue(personnel.getPrenom());
                cell = row.createCell(colNum++);
                CellStyle cellStyle = workbook.createCellStyle();
                cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("yyyy-MM-dd"));
                cell.setCellValue(personnel.getDate_dentree());
                cell.setCellStyle(cellStyle);
                cell = row.createCell(colNum++);
                cell.setCellValue(personnel.getPoste());
                cell = row.createCell(colNum++);
                cell.setCellValue(personnel.getType_demploi());
                cell = row.createCell(colNum++);
                cell.setCellValue(personnel.getCategorie());
                cell = row.createCell(colNum++);
                cell.setCellValue(personnel.getDirection());
                cell = row.createCell(colNum++);
                cell.setCellValue(personnel.getDepartement());
                cell = row.createCell(colNum++);
                cell.setCellValue(personnel.getService());
            }

            try {
                FileOutputStream outputStream = new FileOutputStream(file);
                workbook.write(outputStream);
                workbook.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void exporter_xlsx_actions_planif(File file, ObservableList<Action> data) {
        if(file!=null){
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("actions_planif");
            CreationHelper createHelper = workbook.getCreationHelper();
            int rowNum = 0;
            for (int i=0;i<data.size();i++) {
                Row row = sheet.createRow(rowNum++);
                Action action = data.get(i);
                int colNum = 0;
                Cell cell = row.createCell(colNum++);
                cell.setCellValue(action.getNum());
                cell = row.createCell(colNum++);
                cell.setCellValue(action.getAct());
                cell = row.createCell(colNum++);
                cell.setCellValue(action.getObj_rech());
                cell = row.createCell(colNum++);
                cell.setCellValue(action.getStructure());
                cell = row.createCell(colNum++);
                cell.setCellValue(action.getEff_real_forme());
                cell = row.createCell(colNum++);
                cell.setCellValue(action.getNbr_participants());
                cell = row.createCell(colNum++);
                cell.setCellValue(action.getDuree_jour());
                cell = row.createCell(colNum++);
                CellStyle cellStyle = workbook.createCellStyle();
                cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("yyyy-MM-dd"));
                cell.setCellValue(action.getDebut_formation());
                cell.setCellStyle(cellStyle);
                cell = row.createCell(colNum++);
                cell.setCellValue(action.getCout());
                cell = row.createCell(colNum++);
                cell.setCellValue(action.getOrganisme_formation());
                cell = row.createCell(colNum++);
                cell.setCellValue(action.getLieu_formation());
                cell = row.createCell(colNum++);
                cell.setCellValue(action.getPeriode_devaluation());
            }

            try {
                FileOutputStream outputStream = new FileOutputStream(file);
                workbook.write(outputStream);
                workbook.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void exporter_xlsx_actions_non_planif(File file, ObservableList<Action> data) {
        if(file!=null){
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("actions_non_planif");
            CreationHelper createHelper = workbook.getCreationHelper();
            int rowNum = 0;
            for (int i=0;i<data.size();i++) {
                Row row = sheet.createRow(rowNum++);
                Action action = data.get(i);
                int colNum = 0;
                Cell cell = row.createCell(colNum++);
                cell.setCellValue(action.getNum());
                cell = row.createCell(colNum++);
                cell.setCellValue(action.getAct());
                cell = row.createCell(colNum++);
                cell.setCellValue(action.getObj_rech());
                cell = row.createCell(colNum++);
                cell.setCellValue(action.getStructure());
                cell = row.createCell(colNum++);
                cell.setCellValue(action.getEff_real_forme());
                cell = row.createCell(colNum++);
                cell.setCellValue(action.getNbr_participants());
                cell = row.createCell(colNum++);
                cell.setCellValue(action.getDuree_jour());
                cell = row.createCell(colNum++);
                CellStyle cellStyle = workbook.createCellStyle();
                cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("yyyy-MM-dd"));
                cell.setCellValue(action.getDebut_formation());
                cell.setCellStyle(cellStyle);
                cell = row.createCell(colNum++);
                cell.setCellValue(action.getCout());
                cell = row.createCell(colNum++);
                cell.setCellValue(action.getOrganisme_formation());
                cell = row.createCell(colNum++);
                cell.setCellValue(action.getLieu_formation());
                cell = row.createCell(colNum++);
                cell.setCellValue(action.getPeriode_devaluation());
            }

            try {
                FileOutputStream outputStream = new FileOutputStream(file);
                workbook.write(outputStream);
                workbook.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void exporter_xlsx_suivi(File file,  ObservableList<Suivi> data) {
        if(file!=null){
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("suivi");
            CreationHelper createHelper = workbook.getCreationHelper();
            int rowNum = 0;
            for (int i=0;i<data.size();i++) {
                Row row = sheet.createRow(rowNum++);
                Suivi suivi = data.get(i);
                int colNum = 0;
                Cell cell = row.createCell(colNum++);
                cell.setCellValue(suivi.getAct());
                cell =row.createCell(colNum++);
                cell.setCellValue(suivi.getId());
                cell =row.createCell(colNum++);
                cell.setCellValue(suivi.getNom());
                cell =row.createCell(colNum++);
                cell.setCellValue(suivi.getPrenom());
                cell =row.createCell(colNum++);
                cell.setCellValue(suivi.getFonction());
                cell =row.createCell(colNum++);
                cell.setCellValue(suivi.getDirection());
                cell =row.createCell(colNum++);
                cell.setCellValue(suivi.getCategorie());
                cell =row.createCell(colNum++);
                cell.setCellValue(suivi.getIntitule());
                cell =row.createCell(colNum++);
                CellStyle cellStyle = workbook.createCellStyle();
                cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("yyyy-MM-dd"));
                cell.setCellValue(suivi.getDate_debut());
                cell.setCellStyle(cellStyle);
                cell =row.createCell(colNum++);
                cell.setCellValue(suivi.getDate_fin());
                cell.setCellStyle(cellStyle);
                cell =row.createCell(colNum++);
                cell.setCellValue(suivi.getCout());
                cell =row.createCell(colNum++);
                cell.setCellValue(suivi.getNbr_jrs());
                cell =row.createCell(colNum++);
                cell.setCellValue(suivi.getNbr_hr());
                cell =row.createCell(colNum++);
                cell.setCellValue(suivi.getType_formation());
                cell =row.createCell(colNum++);
                cell.setCellValue(suivi.getOrganisme());
                cell =row.createCell(colNum++);
                cell.setCellValue(suivi.getLieu_formation());
                cell =row.createCell(colNum++);
                cell.setCellValue(suivi.getLieu_formation2());
                cell =row.createCell(colNum++);
                cell.setCellValue(suivi.getPlanification());
                cell =row.createCell(colNum++);
                cell.setCellValue(suivi.getPeriode_eval());
                cell =row.createCell(colNum++);
                cell.setCellValue(suivi.getAttestation_recue());
                cell =row.createCell(colNum++);
                cell.setCellValue(suivi.getAvis_eval_organisme());
                cell =row.createCell(colNum++);
                cell.setCellValue(suivi.getAvis_retour_eval());
                cell =row.createCell(colNum++);
                cell.setCellValue(suivi.getAction_eval_inssuf());
                cell =row.createCell(colNum++);
                cell.setCellValue(suivi.getPrevision_effectif());
                cell =row.createCell(colNum++);
                cell.setCellValue(suivi.getPrevision_cout());
                cell =row.createCell(colNum++);
                cell.setCellValue(suivi.getPrevision_date());
                cell.setCellStyle(cellStyle);
                cell =row.createCell(colNum++);
                cell.setCellValue(suivi.getPrevision_nbr_jour());
                cell =row.createCell(colNum++);
                cell.setCellValue(suivi.getPrevision_nbr_hr());
            }

            try {
                FileOutputStream outputStream = new FileOutputStream(file);
                workbook.write(outputStream);
                workbook.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void vider_table(String table){
        String url = "jdbc:mysql://localhost:3306/gica";
        String user = "root";
        String password = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection(url,user,password);
            Statement stmt=con.createStatement();
            String query = "TRUNCATE `gica`.`"+table+"`";
            System.out.println(query);
            stmt.executeUpdate(query);
            con.close();
        }
        catch(ClassNotFoundException e) {
            System.out.println("ClassNotFoundException");
            e.printStackTrace();
        }
        catch(SQLException e) {
            System.out.println("SQLException");
            e.printStackTrace();
        }
    }
}
