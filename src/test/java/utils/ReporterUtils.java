package utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JSpinner.ListEditor;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import io.cucumber.core.api.Scenario;
import runner.TestRule;

public class ReporterUtils {

	public static ListEditor evidencia;
	public static Document pdf = new Document();
	public static List<String> fileName = new ArrayList<String>();
	public static List<String> stepsDesc = new ArrayList<String>();
	public static int contador = 0;
	public static Date date = new Date();
	private static SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	private static SimpleDateFormat formatterEvidenceDate = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

	public static void logPrint(String strLog) {

		ExtentTest extentTest = TestRule.getExtentTest();

		try {
			screeshot(strLog);
			extentTest.log(Status.INFO, strLog, insertScreenshot(strLog));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void logPass(String strLog) {

		ExtentTest extentTest = TestRule.getExtentTest();
		screeshot(strLog);

		try {
			extentTest.log(Status.PASS, strLog, insertScreenshot(strLog));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void logFail(String strLog) {

		ExtentTest extentTest = TestRule.getExtentTest();
		screeshot(strLog);

		try {
			extentTest.log(Status.FAIL, strLog, insertScreenshot(strLog));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static MediaEntityModelProvider insertScreenshot(String strLog) throws IOException {

		String path = System.getProperty("user.dir") + PropertiesUtil.getProp("screenshot") + strLog + ".png";

		fileName.add(path);
		stepsDesc.add(strLog);

		return MediaEntityBuilder.createScreenCaptureFromPath(path).build();
	}

	private static void screeshot(String strLog) {

		File srcFile = ((TakesScreenshot) TestRule.getDriver()).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(srcFile,
					new File(System.getProperty("user.dir") + PropertiesUtil.getProp("screenshot") + strLog + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void generateEvidencePdf(Scenario cenario) throws Exception, DocumentException {

		Image figura;

		PdfWriter
				.getInstance(pdf,
						new FileOutputStream(System.getProperty("user.dir") + (PropertiesUtil.getProp("evidencia.pdf")
								+ "Cenario_" + cenario.getName() + "_" + formatterEvidenceDate.format(date) + ".pdf")
										.replace(" ", "_").replace(":", "-")));

		pdf.open();

		for (String path : fileName) {

			pdf.setPageSize(PageSize.A4);
			pdf.add(cabecalho("Shoestock", cenario.getName(), stepsDesc.get(contador++)));

			figura = Image.getInstance(path);
			figura.setAbsolutePosition(20, 400);
			figura.scaleToFit(550, 750);

			pdf.add(figura);
			pdf.newPage();
		}

		pdf.close();
	}

	public static PdfPTable cabecalho(String sistema, String ct, String desc) throws Exception, DocumentException {

		Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);

		PdfPTable tableheader = new PdfPTable(new float[] { 0.20f, 0.30f, 0.13f, 0.37f });
		PdfPCell header = new PdfPCell(new Paragraph("Evidencia de Teste"));

		header.setUseBorderPadding(true);
		header.setBorderColor(BaseColor.BLUE);
		header.setHorizontalAlignment(Element.ALIGN_CENTER);
		header.setColspan(4);
		tableheader.setSpacingBefore(20);
		tableheader.addCell(header);

		PdfPCell lblSistema = new PdfPCell(new Paragraph("Sistema", boldFont));
		PdfPCell txtSistema = new PdfPCell(new Paragraph(sistema));
		PdfPCell lblCT = new PdfPCell(new Paragraph("CT", boldFont));
		PdfPCell txtCT = new PdfPCell(new Paragraph(ct));
		PdfPCell lblDesc = new PdfPCell(new Paragraph("Descrição", boldFont));
		PdfPCell txtDesc = new PdfPCell(new Paragraph(desc));
		PdfPCell lblExecutador = new PdfPCell(new Paragraph("Executador", boldFont));
		PdfPCell txtExecutador = new PdfPCell(new Paragraph("Carlos Moreira"));

		PdfPCell lblData = new PdfPCell(new Paragraph("Data", boldFont));
		PdfPCell txtData = new PdfPCell(new Paragraph(formatter.format(date)));

		lblSistema.setBorderColor(BaseColor.BLUE);
		lblSistema.setHorizontalAlignment(Element.ALIGN_TOP);
		txtSistema.setBorderColor(BaseColor.BLUE);

		lblDesc.setBorderColor(BaseColor.BLUE);
		lblDesc.setHorizontalAlignment(Element.ALIGN_TOP);
		txtDesc.setBorderColor(BaseColor.BLUE);

		lblCT.setBorderColor(BaseColor.BLUE);
		lblCT.setHorizontalAlignment(Element.ALIGN_TOP);
		txtCT.setBorderColor(BaseColor.BLUE);

		lblExecutador.setBorderColor(BaseColor.BLUE);
		lblExecutador.setHorizontalAlignment(Element.ALIGN_TOP);
		txtExecutador.setBorderColor(BaseColor.BLUE);

		lblData.setBorderColor(BaseColor.BLUE);
		lblData.setHorizontalAlignment(Element.ALIGN_TOP);
		txtData.setBorderColor(BaseColor.BLUE);

		txtCT.setColspan(3);

		tableheader.addCell(lblSistema);
		tableheader.addCell(txtSistema);
		tableheader.addCell(lblDesc);
		tableheader.addCell(txtDesc);
		tableheader.addCell(lblCT);
		tableheader.addCell(txtCT);
		tableheader.addCell(lblExecutador);
		tableheader.addCell(txtExecutador);
		tableheader.addCell(lblData);
		tableheader.addCell(txtData);

		tableheader.setSpacingAfter(20);

		return tableheader;

	}
}
