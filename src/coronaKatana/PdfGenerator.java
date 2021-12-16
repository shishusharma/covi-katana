package coronaKatana;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;

public class PdfGenerator {
	
	public static void main(String args[]) throws java.io.IOException {
		new Loggedin("xyz","996480701485","7519308095","shishus808@gmail.com",0);
//		try {
//			generateUserDeatil();
//		} catch (FileNotFoundException | MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	
	
	public static void generateUserDeatil() throws java.io.IOException {
		// Creating a PdfWriter 
		String dest = "C:/itextExamples/sample.pdf"; 
		PdfWriter writer = new PdfWriter(dest);
		
		// Creating a PdfDocument  
		PdfDocument pdfDoc = new PdfDocument(writer);
		
		
		// Creating a Document   
		Document document = new Document(pdfDoc);
		
		
		
		//for creating line
		// Creating a PdfCanvas object      
		// Creating a new page       
	      PdfPage pdfPage = pdfDoc.addNewPage(); 
	   // Creating an ImageData object 
	      String image = "img\\logo.jpg"; 
	     
	      ImageData data = ImageDataFactory.create(image);
	      
	   // Creating an Image object 
	      Image img = new Image(data); 
	      //img.setFixedPosition(1, 100, 20);
	   // Setting the position of the image to the center of the page 
		     img.scaleAbsolute(50, 50);
		     img.setFixedPosition(250,770);
	   
	      
	   // Adding image to the document 
	      document.add(img);
	             
	      
	   // Setting font of the text PdfFont 
	     PdfFont font = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD); 
	      
		
		//creating Paragraphs
		Paragraph head1=new Paragraph("Certificate for COVID-19 Vaccination\r\n");
		head1.setFont(font);
		head1.setFontSize(20f);
		head1.setFixedPosition(120, 730, 700);
		document.add(head1);
		
		//creating Paragraphs
		Paragraph head2=new Paragraph("Issued in India by Ministry of Health & Family Welfare, Govt. of India\n");
		head2.setFont(font);
		head2.setFontSize(10f);
		head2.setFixedPosition(130, 715, 700);
		document.add(head2);
		
		Paragraph Beneficiary=new Paragraph("Beneficiary Details\r\n");
		Beneficiary.setFont(PdfFontFactory.createFont(FontConstants.HELVETICA));
		Beneficiary.setFontSize(15f);
		Beneficiary.setFixedPosition(80, 660, 700);
		document.add(Beneficiary);
		
		//for line
		  PdfCanvas canvas = new PdfCanvas(pdfPage);    
	      // Initial point of the line       
	      canvas.moveTo(80, 658);              
	      // Drawing the line       
	      canvas.lineTo(205, 658);  
		 // Closing the path stroke       
	      canvas.closePathStroke();
	      // Closing the document 
		
		//name
		Paragraph BName=new Paragraph("Beneficiary Name \r\n");
		BName.setFont(PdfFontFactory.createFont(FontConstants.TIMES_ROMAN));
		BName.setFontSize(13f);
		BName.setFixedPosition(80, 630, 700);
		document.add(BName);
		
		String nm="shishu";
		Paragraph Name=new Paragraph(nm+"\r\n");
		Name.setFont(PdfFontFactory.createFont(FontConstants.TIMES_ROMAN));
		Name.setFontSize(13f);
		Name.setFixedPosition(300, 630, 700);
		document.add(Name);
		
		//gender
		Paragraph BGen=new Paragraph("Gender\r\n");
		BGen.setFont(PdfFontFactory.createFont(FontConstants.TIMES_ROMAN));
		BGen.setFontSize(13f);
		BGen.setFixedPosition(80, 610, 700);
		document.add(BGen);
		
		String mf="";
		int mfg=0;
		if(mfg==0)
			mf="Male";
		else 
			mf="Female";
		Paragraph Gen=new Paragraph(mf+"\r\n");
		Gen.setFont(PdfFontFactory.createFont(FontConstants.TIMES_ROMAN));
		Gen.setFontSize(13f);
		Gen.setFixedPosition(300, 610, 700);
		document.add(Gen);
		
		//Aadhaar
		Paragraph BAdhar=new Paragraph("ID (Aadhaar)\r\n");
		BAdhar.setFont(PdfFontFactory.createFont(FontConstants.TIMES_ROMAN));
		BAdhar.setFontSize(13f);
		BAdhar.setFixedPosition(80, 590, 700);
		document.add(BAdhar);
		
		String ad="996480701485";
		Paragraph Adhar=new Paragraph(ad+"\r\n");
		Adhar.setFont(PdfFontFactory.createFont(FontConstants.TIMES_ROMAN));
		Adhar.setFontSize(13f);
		Adhar.setFixedPosition(300, 590, 700);
		document.add(Adhar);
		
		
		//Vaccination Status
		int status=1;
		String stus="";
		if(status==2) {
			stus="Fully Vaccinated (2 Dose)";
		}
		else {
			stus="Half Vaccinated (1 Dose)";
		}
		
		Paragraph BVstus=new Paragraph("Vaccination Status\r\n");
		BVstus.setFont(PdfFontFactory.createFont(FontConstants.TIMES_ROMAN));
		BVstus.setFontSize(13f);
		BVstus.setFixedPosition(80, 570, 700);
		document.add(BVstus);
		
		Paragraph Vstus=new Paragraph(stus+"\r\n");
		Vstus.setFont(PdfFontFactory.createFont(FontConstants.TIMES_ROMAN));
		Vstus.setFontSize(13f);
		Vstus.setFixedPosition(300, 570, 700);
		document.add(Vstus);
		
		
		
		
		//Vaccination heading
		Paragraph VacDetail=new Paragraph("Vaccination Details\r\n");
		VacDetail.setFont(PdfFontFactory.createFont(FontConstants.HELVETICA));
		VacDetail.setFontSize(15f);
		VacDetail.setFixedPosition(80, 531, 700);
		document.add(VacDetail);
		
		
		//for line
		  PdfCanvas canvas1 = new PdfCanvas(pdfPage);    
	      // Initial point of the line       
	      canvas1.moveTo(80,530 );              
	      // Drawing the line       
	      canvas1.lineTo(205, 530);  
		 // Closing the path stroke       
	      canvas1.closePathStroke();
	      // Closing the document 
	      
	      int x=0,y=-20;
	      
	    Paragraph Vac_name=new Paragraph("Vaccine Name\r\n");
	    Vac_name.setFont(PdfFontFactory.createFont(FontConstants.TIMES_ROMAN));
	    Vac_name.setFontSize(13f);
	    Vac_name.setFixedPosition(80, 510+y, 700);
		document.add(Vac_name);
	
		
		//VACCINE NAME
		String Vanm="COVIAKATANA";
		Paragraph Vacnm=new Paragraph(Vanm+"\r\n");
		Vacnm.setFont(PdfFontFactory.createFont(FontConstants.TIMES_ROMAN));
		Vacnm.setFontSize(13f);
		Vacnm.setFixedPosition(300, 510+y, 700);
		document.add(Vacnm);
		
		//Vaccine type
		Paragraph VType=new Paragraph("Vaccine Type\r\n");
		VType.setFont(PdfFontFactory.createFont(FontConstants.TIMES_ROMAN));
		VType.setFontSize(13f);
		VType.setFixedPosition(80, 490+y, 700);
		document.add(VType);
		
		//vaccine type
		String vacType="COVID-19 vaccine, non-replicating viral vector";
		Paragraph VacNm=new Paragraph(vacType+"\r\n");
		VacNm.setFont(PdfFontFactory.createFont(FontConstants.TIMES_ROMAN));
		VacNm.setFontSize(13f);
		VacNm.setFixedPosition(300, 490+y, 700);
		document.add(VacNm);
		
		//Manufacture
		Paragraph Vacm=new Paragraph("Manufacturer\r\n");
		Vacm.setFont(PdfFontFactory.createFont(FontConstants.TIMES_ROMAN));
		Vacm.setFontSize(13f);
		Vacm.setFixedPosition(80, 470+y, 700);
		document.add(Vacm);
		
		String VacmN="Motilal Institute of India";
		Paragraph Vacms=new Paragraph(VacmN+"\r\n");
		Vacms.setFont(PdfFontFactory.createFont(FontConstants.TIMES_ROMAN));
		Vacms.setFontSize(13f);
		Vacms.setFixedPosition(300, 470+y, 700);
		document.add(Vacms);
		
		
		//Vaccination Dose Status
		int VDS=2;
		String VDStus="";
		if(VDS==2) {
			VDStus="1/2				2/2";
		}
		else {
			VDStus="1/2";
		}
		
		Paragraph BVstatus=new Paragraph("Vaccination Status\r\n");
		BVstatus.setFont(PdfFontFactory.createFont(FontConstants.TIMES_ROMAN));
		BVstatus.setFontSize(13f);
		BVstatus.setFixedPosition(80, 450+y, 700);
		document.add(BVstatus);
		
		Paragraph VDSp=new Paragraph(VDStus+"\r\n");
		VDSp.setFont(PdfFontFactory.createFont(FontConstants.TIMES_ROMAN));
		VDSp.setFontSize(13f);
		VDSp.setFixedPosition(300, 450+y, 700);
		document.add(VDSp);

		//Date of dose
		int DOD=2;
		String DODS="";
		if(DOD==2) {
			DODS+="Date1			Date2";
		}
		else {
			DODS+="Date1";
		}
		
		Paragraph DODp=new Paragraph("Date of Dose\r\n");
		DODp.setFont(PdfFontFactory.createFont(FontConstants.TIMES_ROMAN));
		DODp.setFontSize(13f);
		DODp.setFixedPosition(80, 430+y, 700);
		document.add(DODp);
		
		Paragraph DODpp=new Paragraph(DODS+"\r\n");
		DODpp.setFont(PdfFontFactory.createFont(FontConstants.TIMES_ROMAN));
		DODpp.setFontSize(13f);
		DODpp.setFixedPosition(300, 430+y, 700);
		document.add(DODpp);


		//Batch No
		int BATCHN=2;
		String Batchno="";
		if(BATCHN==2) {
			Batchno="bATCH1			bATCH2";
		}
		else {
			Batchno="bATCH";
		}
		
		Paragraph Batchp=new Paragraph("Batch Number\r\n");
		Batchp.setFont(PdfFontFactory.createFont(FontConstants.TIMES_ROMAN));
		Batchp.setFontSize(13f);
		Batchp.setFixedPosition(80, 410+y, 700);
		document.add(Batchp);
		
		Paragraph Batchpp=new Paragraph(Batchno+"\r\n");
		Batchpp.setFont(PdfFontFactory.createFont(FontConstants.TIMES_ROMAN));
		Batchpp.setFontSize(13f);
		Batchpp.setFixedPosition(300, 410+y, 700);
		document.add(Batchpp);

		//Vaccinated by
		
		String VACBY="Shishu shamr";
				
		Paragraph vacp=new Paragraph("Vaccinated By\r\n");
		vacp.setFont(PdfFontFactory.createFont(FontConstants.TIMES_ROMAN));
		vacp.setFontSize(13f);
		vacp.setFixedPosition(80, 390+y, 700);
		document.add(vacp);
		
		Paragraph vacpp=new Paragraph(VACBY+"\r\n");
		vacpp.setFont(PdfFontFactory.createFont(FontConstants.TIMES_ROMAN));
		vacpp.setFontSize(13f);
		vacpp.setFixedPosition(300, 390+y, 700);
		document.add(vacpp);

		//Vaccinated AT
		
		String VACAT="Indrapuri rd no 12 bihar";
				
		Paragraph vacpa=new Paragraph("Vaccinated AT\r\n");
		vacpa.setFont(PdfFontFactory.createFont(FontConstants.TIMES_ROMAN));
		vacpa.setFontSize(13f);
		vacpa.setFixedPosition(80, 370+y, 700);
		document.add(vacpa);
		
		Paragraph vacppa=new Paragraph(VACAT+"\r\n");
		vacppa.setFont(PdfFontFactory.createFont(FontConstants.TIMES_ROMAN));
		vacppa.setFontSize(13f);
		vacppa.setFixedPosition(300, 370+y, 700);
		document.add(vacppa);



		
		 
		document.close();
	}

}
