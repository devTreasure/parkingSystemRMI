package ParkingSystem.Client.UI;

import java.awt.Choice;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.WindowEvent;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import ParkingSystem.Common.IparkingSystemManager;
import ParkingSystem.Entities.CashPayStrategy;
import ParkingSystem.Entities.CreditCard;
import ParkingSystem.Entities.CreditCardStrategy;
import ParkingSystem.Entities.EntryGate;
import ParkingSystem.Entities.GateStatus;
import ParkingSystem.Entities.ParkingStatus;
import ParkingSystem.Entities.PaymentType;
import ParkingSystem.Entities.ReportType;
import ParkingSystem.Entities.Status;
import ParkingSystem.Entities.Ticket;
import ParkingSystem.Entities.TicketStatus;
import ParkingSystem.Entities.PaymentContext;
import ParkingSystem.Reports.DailyReport;
import ParkingSystem.Reports.HourlyData;
import ParkingSystem.Reports.HourlyReport;
import ParkingSystem.Reports.ReportCollection;
import ParkingSystem.controller.ParkingSystemManager;

public class parkingGUI extends JFrame implements Serializable {

	/**
	 * 
	 */

	javax.swing.JButton btnReport;
	java.awt.Choice choiseReport;
	javax.swing.JButton buttonPrintTicket;
	javax.swing.JButton buttonPayment;

	javax.swing.JButton buttonExit;
	javax.swing.JButton buttonOpenGate;
	javax.swing.JButton buttonClosegate;
	javax.swing.JButton buttonFarecalc;
	javax.swing.JLabel jLabel1;
	javax.swing.JTextField jTextField1;
	javax.swing.JTextField jTextField2;
	javax.swing.JTextField jTextField3;
	javax.swing.JLabel jLabel3;
	javax.swing.JLabel jLabel2;
	javax.swing.JLabel jLabel4;
	javax.swing.JLabel jLabel5;
	javax.swing.JLabel jLabel6;
	javax.swing.JLabel jLabel7;
	javax.swing.JLabel jLabel8;
	javax.swing.JLabel jLabel9;
	javax.swing.JLabel jLabel10;
	javax.swing.JLabel jLabel11;
	javax.swing.JLabel jLabel12;
	javax.swing.JLabel jLabel14;
	javax.swing.JLabel jLabel15;
	java.awt.TextField textField3;
	java.awt.TextField textField1;
	javax.swing.JTextField jTextField4;
	javax.swing.JTextField jTextField5;
	javax.swing.JTextField jTextField6;
	javax.swing.JTextField jTextField7;
	javax.swing.JTextField jTextField13;
	javax.swing.JLabel jLabel13;
	javax.swing.JTextField jTextField8;
	javax.swing.JTextField jTextField9;
	javax.swing.JTextField jTextField10;
	javax.swing.JTextField jTextField11;
	javax.swing.JTextField jTextField12;
	java.awt.Label label1;
	java.awt.Label label2;
	java.awt.Label label3;
	java.awt.Label label4;
	java.awt.Label label5;
	java.awt.Label label6;
	java.awt.Label label11;
	javax.swing.JButton buttonGate1;
	javax.swing.JButton buttonGate3;
	javax.swing.JButton buttonGate2;
	javax.swing.JButton jbu;
	javax.swing.JButton jButton3;
	javax.swing.JButton jButton4;
	javax.swing.JButton jButton1;
	javax.swing.JButton jButton2;
	java.awt.Label label10;
	javax.swing.JButton jButton5;
	java.awt.Button button1;
	java.awt.Label label7;
	java.awt.Label label8;
	java.awt.Label label9;
	java.awt.Checkbox checkbox2;
	java.awt.TextField textField2;
	javax.swing.JButton jButton6;
	private java.awt.Checkbox checkbox1;
	public java.awt.Choice choice1;

	IparkingSystemManager parkingManager = null;

	boolean isCreditpay;
	boolean isCashPay;
	int entryGateNumber = 0;

	private void openGateActionPerformed(java.awt.event.ActionEvent evt) {

		try {

			// Get ticket id from UI
			String currentTicketId = choice1.getSelectedItem();
			jTextField3.setText("Opening Gate");

			Status status = parkingManager.openEntryGateFor(currentTicketId, entryGateNumber);
			jTextField3.setText(status.getMessage());

			// if (parkingManager.ticket.getTicektStatus() ==
			// TicketStatus.Active) {
			// parkingManager.getGatemanagement().gate =
			// parkingManager.getGatemanagement().OpenEntryGate(
			// parkingManager.getGatemanagement().gate.GateId);
			//
			// // added for fraud
			// // prevention check
			// parkingManager.getFraudManager().ticketgatecollection.put(parkingManager.ticket,
			// parkingManager.getGatemanagement().gate);
			//
			// jTextField3.setText(parkingManager.getGatemanagement().gate.gateStatus.toString());
			//
			// if (parkingManager.getGatemanagement().gate.gateStatus ==
			// GateStatus.Open) {
			// // objticketmanager.getGatemanagement().gate
			// // =
			// //
			// objticketmanager.getGatemanagement().closeEntryGate(objticketmanager.getGatemanagement().gate.GateId);
			// parkingManager.getGatemanagement().closeEntryGate(parkingManager.getGatemanagement().gate.GateId);
			// }
			// jTextField3.setText(parkingManager.getGatemanagement().gate.gateStatus.toString());
			//
			// } else {
			// jTextField3.setText(parkingManager.getGatemanagement().gate.gateStatus.toString());
			// }
		} catch (Exception ex) {

		}

	}

	private void button1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void checkbox2ItemStateChanged(java.awt.event.ItemEvent evt) {
		// TODO add your handling code here:
		// JOptionPane.showMessageDialog(null,"Please enter date MM/dd/yy ");

		if (checkbox2.getState()) {
			jButton6.setEnabled(true);
		} else {
			jButton6.setEnabled(false);
		}

	}

	private void closeGateActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			//parkingManager.closeEntryGate(entryGateNumber);
			
			Status status=parkingManager.closeTheEntryGate(entryGateNumber);
			// parkingManager.getGatemanagement().closeEntryGate(parkingManager.getGatemanagement().gate.GateId);
		} catch (Exception ex) {

		}
	}

	private Date setTheHourTimeSimulation() {

		String stDate = JOptionPane.showInputDialog("Enter Date Input: mm/dd/yy");

		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");

		Date d1 = null;

		try {

			d1 = sdf.parse(stDate);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Calendar c = Calendar.getInstance();

		JOptionPane.showMessageDialog(null, "Please enter date MM/dd/yy ");

		String hour = JOptionPane.showInputDialog("Enter Hour/Minute Input  :  (HH/mm) Format");

		String[] hrArray = hour.split(":");

		int hourInput = Integer.parseInt(hrArray[0]);
		int minuteInput = Integer.parseInt(hrArray[1]);

		if (hourInput > 25 || hourInput < 0) {
			JOptionPane.showMessageDialog(null, "Please entervalid hours");
		} else {
			// d1.setHours(hourInput);
		}

		if (minuteInput > 61 || minuteInput < 0) {
			JOptionPane.showMessageDialog(null, "Please enter valid minutes");
		} else {

			d1.setMinutes(minuteInput);
		}

		return d1;

	}

	// TODO DO You need this method? openGateActionPerformed method is doing
	// same thig.
	// private void entrygateClosingActionPerformed(java.awt.event.ActionEvent
	// evt) {
	//
	// try {
	//
	// if (parkingManager.getGatemanagement().gate.gateStatus ==
	// GateStatus.Open) {
	// parkingManager.getGatemanagement().closeEntryGate(parkingManager.getGatemanagement().gate.GateId);
	//
	// // ticket with gate
	// // movement is added
	// // in collection to
	// // check
	// // fraud
	// // activity
	//
	// parkingManager.getFraudManager().ticketgatecollection.put(parkingManager.ticket,
	// parkingManager.getGatemanagement().gate);
	//
	// jTextField3.setText(parkingManager.getGatemanagement().gate.gateStatus.toString());
	// }
	// } catch (Exception ex) {
	//
	// }
	// }

	private void exitActionPerformed(java.awt.event.ActionEvent evt) {
		try {

			UUID ticketID = null;

			try {
				ticketID = UUID.fromString(choice1.getSelectedItem());
			} catch (Exception ex) {

			}

			Status exitStatus = parkingManager.processExitFor(ticketID);
			JOptionPane.showMessageDialog(null, exitStatus.getMessage());

			if (exitStatus.getStatus()) {

				Ticket t = parkingManager.getThetheTicketStatusAfterExitOperation(choice1.getSelectedItem());

				jTextField10.setText(t.getTicketID().toString());
				jTextField11.setText(t.getTicektStatus().toString());
				jTextField12.setText(t.getEntryTime().toString());
			}

			// parkingManager.getFraudManager().checkentryExitOperation();

			int parkingOccupancy = parkingManager.getTheParkingOccupancy();

			label5.setText(String.valueOf(parkingOccupancy));
			// Gate
			// g=objticketmanager.gatemanagement.ExitGate(1);

			if (parkingManager.isCurrentparkingFull()) {
				buttonPrintTicket.setVisible(false);

			} else

			{

				buttonPrintTicket.setVisible(true);
				jTextField2.setText(ParkingStatus.Open.toString());

			}
		} catch (Exception ex) {

		}

	}

	public void paymentActionPerformed(ActionEvent evt) {

		try {

			ArrayList<String> error = new ArrayList<String>();
			Status status = null;
			String regex = "\\d+";
			Boolean validentry = false;

			if (isCreditpay) {

				if (jTextField4.getText().length() > 0)

				{
					if (jTextField4.getText().length() > 16 || jTextField4.getText().length() < 16) {
						JOptionPane.showMessageDialog(null, "Please enter valid card number");
						error.add("Please enter valid card number");
					}

					boolean validate = jTextField4.getText().matches("[0-9]+");
					;

					if (!validate) {
						JOptionPane.showMessageDialog(null, "Please enter Numeric values only.");
						error.add("Please enter Numeric values only.");
						validentry = false;

					} else

					{
						validentry = true;

					}

				}

				else {
					JOptionPane.showMessageDialog(null, "CreditCard number is required");
					error.add("CreditCard number is required");
					validentry = false;
				}
				// JOptionPane.showMessageDialog(null,
				// "My Goodness, this is a pay");

				if (jTextField7.toString().length() > 0) {
					boolean validate = jTextField7.getText().matches("[0-9]+");
					;

					if (!validate) {
						error.add("Please enter Numeric values only.");
						JOptionPane.showMessageDialog(null, "Please enter Numeric values only.");

					} else {
						if (jTextField7.getText().length() > 3 || (jTextField7.getText().length() < 3)) {
							error.add("Entered cvv is incorrect.");
							JOptionPane.showMessageDialog(null, "Entered cvv is incorrect.");
							validentry = false;
						} else
							validentry = true;
					}

				}

				else {
					validentry = false;
					error.add("Entered cvv is incorrect.");
					JOptionPane.showMessageDialog(null, "Please enter cvv.");
				}

				if (jTextField6.toString().length() > 0) {
					Calendar cal = Calendar.getInstance();

					Date today = Calendar.getInstance().getTime();

					cal.setTime(today);

					int year = cal.get(Calendar.YEAR);
					int month = cal.get(Calendar.MONTH) + 1;

				//	String entermonth[] = new String[2];

					try {
						String string = jTextField6.getText().toString();
						String[] entermonth = string.split("/");

						if (entermonth.length > 0) {

							if (entermonth[0].length() > 2) {
								error.add("Please enter valid month");

							}

							if (entermonth[0].length() > 4) {
								error.add("Please enter valid year");
							}

							int entedmonth = Integer.parseInt(entermonth[0]);
							int entedyear = Integer.parseInt(entermonth[1]);

							if (entedyear < year) {

								validentry = false;
								error.add("Please enter valid month/year.");
								JOptionPane.showMessageDialog(null, "Please enter valid month/year.");
							}

							else if (entedyear == year) {
								if (entedmonth < month) {

									validentry = false;

								} else if (entedmonth > month) {

									validentry = true;
								} else // enter month is grater than currecnt
										// calander month
								{

									validentry = true;
								}

							} else if (entedyear > year) {

								validentry = true;
							}
						}

						else {
							validentry = false;
							error.add("Please enter the date  in mm/YYYY format.");
							JOptionPane.showMessageDialog(null, "Please enter the date  in mm/YYYY format.");
						}

					} catch (Exception e)

					{
						validentry = false;
						error.add("Please enter valid month/year.");
						JOptionPane.showMessageDialog(null, "Please enter valid month/year.");
					}
				}

				Calendar c = Calendar.getInstance();
				Date paymentDt = c.getTime();
//				CreditCard card = parkingManager.getCreditCard();
				CreditCard card = new CreditCard();
				// we need to capture failed payments as well?
				card.setCreditcardpaymentTime(paymentDt);

				if (validentry && error.size() < 1) {

					card.setCCNumner(jTextField4.getText());
					card.setTicketID(UUID.fromString(jTextField10.getText()));
					card.setExpiryDate(jTextField6.getText());
					card.setCvvNumber(Integer.parseInt(jTextField7.getText()));
					// Date is set outside
					Double dueAmount = Double.parseDouble(label10.getText());
					card.setAmount(dueAmount);
					
					
//					Ticket t = parkingManager.getTheTicketfromID(choice1.getSelectedItem());
					
					Ticket t = parkingManager.makePayment(card, choice1.getSelectedItem(), PaymentType.Credit);
									

					

//					Double amount = context.Pay(t, card, null);

					if (t.getTicketAmount() == 0)
						status = new Status(true, "payment has been succesful");

					jTextField8.setText(status.getMessage());
				}

			}

			if (isCashPay)

			{

				PaymentContext context = new PaymentContext();

				// context.setPaymentStrategy(new CashPayStrategy());
				context.setPaymentType(PaymentType.Cash);

				Ticket t = parkingManager.getTheTicketfromID(choice1.getSelectedItem());

				Double amount = context.Pay(t, null, null);

				// double amount =
				// parkingManager.processPayment(parkingManager.ticket, null);

				if (amount == 0)
					status = new Status(true, "payment has been succesful");

				jTextField8.setText(status.getMessage());
			}

		}

		catch (Exception ex) {

		}

	}

	public void printTicketActionPerformed(java.awt.event.ActionEvent evt) {
		try {

			if (parkingManager.isCurrentparkingFull()) {
			} else {

				buttonPrintTicket.setVisible(true);

			}

			if (entryGateNumber == 1 || entryGateNumber == 2 || entryGateNumber == 3 && (!parkingManager.isCurrentparkingFull()))

			{
				jLabel4.setText("Printing Ticket...Please Wait");

				Ticket ticket = null;

				ticket = parkingManager.printTicketOperation();

				ParkingStatus parkingStatus = parkingManager.getTheCurrentparkingStatus();
				jTextField2.setText(parkingStatus.toString());

				// Ticket ticekt=parkingManager

				jTextField10.setText(ticket.getTicketID().toString());

				jTextField13.setText(ticket.getNamePlate());

				jTextField11.setText(ticket.getTicektStatus().toString());
				jTextField12.setText(ticket.getEntryTime().toString());

				jLabel4.setText("Success..Collect the ticket");

				String currentCount = Integer.toString(parkingManager.getTheParkingOccupancy());

				label5.setText(currentCount);
				Status status = null;
				if (ticket.getTicektStatus() == TicketStatus.Active) 
				{
					// parkingManager.getGatemanagement().gate =
					// parkingManager.getGatemanagement().OpenEntryGate(parkingManager.getGatemanagement().gate.GateId);
					String ticketID = ticket.getTicektID().toString();
					// choice1.getSelectedItem();

					jTextField3.setText("Opening");

					status = parkingManager.openEntryGateFor(ticketID, entryGateNumber);
					JOptionPane.showMessageDialog(null, "Gate is Opened");

					JOptionPane.showMessageDialog(null, "Succesful Entry");

					//status = parkingManager.closeEntryGate(entryGateNumber);
					//status= parkingManager.closeEntryGate(entryGateNumber);
					Status gatestatus=null;
					try
					{
						gatestatus=parkingManager.closeTheEntryGate(entryGateNumber);
						if(gatestatus!=null)
						jTextField3.setText(gatestatus.getMessage());
					}
					catch(Exception ex)
					{
						ex.printStackTrace();
					}

					
					

					// parkingManager.getFraudManager().ticketgatecollection.put(parkingManager.ticket,parkingManager.getGatemanagement().gate);

					// jTextField3.setText(parkingManager.getGatemanagement().gate.gateStatus.toString());
					// jTextField3.setText(status.getMessage());

					// if
					// (status.getMessage().equals(GateStatus.Open.toString()))

					// if (parkingManager.getGatemanagement().gate.gateStatus ==
					// GateStatus.Open)

					// {
					// parkingManager.closeEntryGate(entryGateNumber);

					// parkingManager.getGatemanagement().closeEntryGate(parkingManager.getGatemanagement().gate.GateId);
					JOptionPane.showMessageDialog(null, "Gate closed");

					// parkingManager.getGatemanagement().gate.GateId = 0;
					entryGateNumber = 0;
					// }

					if (ticket != null && ticket.getTicektStatus() == TicketStatus.Active) {
						choice1.add(ticket.getTicketID().toString());
					}

					else {
						jLabel4.setText("Error...Please Retry");
					}

					// jTextField3.setText(status.toString());

				} else if (status.equals("Invalid Ticket")) {
					jTextField3.setText("Closed");

					// jTextField3.setText(parkingManager.getGatemanagement().gate.gateStatus.toString());
				}
			} else

			{
				JOptionPane.showMessageDialog(null, "please select the entry gate");
			}
		} catch (Exception ex) {

		}

	}

	private void buttonGate1ActionPerformed(java.awt.event.ActionEvent evt) throws RemoteException {

		entryGateNumber = 1;
		// parkingManager.getGatemanagement().gate = new EntryGate(1);
		JOptionPane.showMessageDialog(null, "Entry gate 1 is Selected, Please print ticket now");

	}

	private void buttonGate2ActionPerformed(java.awt.event.ActionEvent evt) throws RemoteException {
		// TODO add your handling code here:

		entryGateNumber = 2;
		// parkingManager.getGatemanagement().gate = new EntryGate(2);
		JOptionPane.showMessageDialog(null, "Entry gate 2 is Selected, Please print ticket now");

	}

	private void buttonGate3ActionPerformed(java.awt.event.ActionEvent evt) throws RemoteException {
		// TODO add your handling code here:
		entryGateNumber = 3;
		// parkingManager.getGatemanagement().gate = new EntryGate(3);
		JOptionPane.showMessageDialog(null, "Entry gate 3 is Selected, Please print ticket now");

	}

	private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) throws Exception {
	
		String choiceSelection = choiseReport.getSelectedItem();
		double totalCollection = 0;
		if (choiceSelection == "Hourly") {
			Date dst = null;
			
			SimpleDateFormat hrly = new SimpleDateFormat("MM/dd/yy");

			List<ReportCollection> reportWeekly = new ArrayList<ReportCollection>();

			String stDate = JOptionPane.showInputDialog("Enter start Date Input: MM/dd/yy");

			try {

				dst = hrly.parse(stDate);

				for (ReportCollection c : parkingManager.getCreditReportcollection()) {

					if (hrly.format(c.getCreditcardpaymentTime()).equals(stDate)) {
						totalCollection += c.getAmount();
						reportWeekly.add(c);
					}
				}

				for (ReportCollection cc : reportWeekly)

				{

					System.out.println((String.format("    %tc             %s         %s       %f   ", cc.getCreditcardpaymentTime(), cc
							.getCCNumner().toString(), cc.getTicketID().toString(), cc.getAmount())));
				}
				System.out.println((String.format("    Total collection Amount :      %f   ", totalCollection)));

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// List<HourlyData> exitdata = new ArrayList<HourlyData>();
		}
	}

	private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) throws Exception {
		// TODO add your handling code here:
		JOptionPane.showMessageDialog(null, "Date change clicked");

		// setTheHourTimeSimulation
		// Date dateEntry= c.

		if (!checkbox1.getState()) {
			String ticketID = choice1.getSelectedItem();

			Ticket t = parkingManager.getTheTicketfromID(ticketID);
			if (t != null) {
				t.setEntryTime(setTheHourTimeSimulation());
			}
		}

	}

	private void choice1ItemStateChanged(java.awt.event.ItemEvent evt) {
		// TODO add your handling code here:

	}

	public void constructTable() {

	}

	private void ReportActionPerformed(java.awt.event.ActionEvent evt) throws ParseException, RemoteException {
		// TODO add your handling code here:
		// Report type enum need to be used for replacing
		// integer arg

		ReportType reportType = null;
		List<Ticket> reportHourlyData = new ArrayList<Ticket>();
		/*
		 * 
		 * SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy hh:mm:ss");
		 * 
		 * Date d1 = sdf.parse("07/01/12 01:23:45");
		 * 
		 * Date d2 = sdf.parse("07/01/14 01:35:45"); Date d22 =
		 * sdf.parse("07/01/14 02:55:56");
		 * 
		 * Date d3 = sdf.parse("07/01/14 01:45:45"); Date d33 =
		 * sdf.parse("07/01/14 01:55:23");
		 * 
		 * Date d4 = sdf.parse("07/01/14 01:55:45");
		 * 
		 * Date d5 = sdf.parse("07/01/14 04:35:45"); Date d6 =
		 * sdf.parse("07/01/14 04:55:45"); Date d7 =
		 * sdf.parse("07/01/14 04:10:45");
		 * 
		 * Date d8 = sdf.parse("07/01/14 11:10:45"); Date d9 =
		 * sdf.parse("07/01/14 11:59:45");
		 * 
		 * Ticket t1 = new Ticket();
		 * 
		 * t1.setEntryTime(d1);
		 * 
		 * t1.setTicketID(UUID.randomUUID());
		 * 
		 * Ticket t2 = new Ticket(); t2.setEntryTime(d2); t2.setExitTime(d22);
		 * t2.setTicketID(UUID.randomUUID());
		 * 
		 * Ticket t3 = new Ticket(); t3.setEntryTime(d3);
		 * 
		 * t3.setExitTime(d33);
		 * 
		 * t2.setTicketID(UUID.randomUUID());
		 * 
		 * Ticket t4 = new Ticket(); t4.setEntryTime(d4);
		 * t4.setTicketID(UUID.randomUUID());
		 * 
		 * Ticket t5 = new Ticket(); t5.setEntryTime(d5);
		 * t5.setTicketID(UUID.randomUUID());
		 * 
		 * Ticket t6 = new Ticket(); t6.setEntryTime(d6);
		 * t6.setTicketID(UUID.randomUUID());
		 * 
		 * Ticket t7 = new Ticket(); t7.setEntryTime(d7);
		 * t7.setTicketID(UUID.randomUUID());
		 * 
		 * Ticket t8 = new Ticket(); t8.setEntryTime(d8);
		 * t8.setTicketID(UUID.randomUUID());
		 * 
		 * Ticket t9 = new Ticket(); t9.setEntryTime(d9);
		 * t9.setTicketID(UUID.randomUUID());
		 * 
		 * reportHourlyData.add(t1); reportHourlyData.add(t2);
		 * reportHourlyData.add(t3); reportHourlyData.add(t4);
		 * 
		 * reportHourlyData.add(t5);
		 * 
		 * reportHourlyData.add(t6);
		 * 
		 * reportHourlyData.add(t7);
		 * 
		 * reportHourlyData.add(t8); reportHourlyData.add(t9);
		 * 
		 * // System.out.print(choiseReport.getSelectedItem());
		 */

		String choiceSelection = choiseReport.getSelectedItem();

		if (choiceSelection == "Daily")

		{

			SimpleDateFormat hrly = new SimpleDateFormat("MM/dd/yy");

			List<HourlyData> reportHourly = new ArrayList<HourlyData>();

			List<HourlyData> exitdata = new ArrayList<HourlyData>();

			String stDate = JOptionPane.showInputDialog("Enter start Date Input: mm/dd/yy");

			Date dt = hrly.parse(stDate);

			int y = 0;

			int k = 0;

			reportType = ReportType.Daily;

			List<HourlyData> reportHourly1 = parkingManager.getTheDataCollectionforReport(reportType, dt);

			/*
			 * 
			 * while (y <= 11.59) { HourlyData datacount = null; HourlyData data
			 * = null; HourlyData Exitdata = null;
			 * 
			 * int count = 0; int hour = 0; int exitcount = 0;
			 * 
			 * data = new HourlyData();
			 * 
			 * k = y;
			 * 
			 * data.setTimeperiod(String.format("Hours %d -  %d", k, ++k));
			 * 
			 * reportHourly1.add(data);
			 * 
			 * for (Ticket t : reportHourlyData) {
			 * 
			 * if (hrly.format(t.getEntryTime()).equals(stDate)) {
			 * 
			 * if ((t.getEntryTime() != null && t.getEntryTime() .getHours() ==
			 * y)) {
			 * 
			 * if (t.getEntryTime().getMinutes() <= 59) { data = new
			 * HourlyData();
			 * 
			 * count++; hour = y;
			 * 
			 * data.setEntrydt(t.getEntryTime());
			 * data.setTicketid(t.getTicektID());
			 * 
			 * reportHourly1.add(data);
			 * 
			 * }
			 * 
			 * }
			 * 
			 * if ((t.getExitTime() != null && t.getExitTime() .getHours() ==
			 * y)) {
			 * 
			 * if (t.getExitTime().getMinutes() <= 59) { Exitdata = new
			 * HourlyData();
			 * 
			 * exitcount++;
			 * 
			 * hour = y;
			 * 
			 * Exitdata.setExitdt(t.getExitTime());
			 * Exitdata.setTicketid(t.getTicektID());
			 * 
			 * reportHourly1.add(Exitdata);
			 * 
			 * }
			 * 
			 * }
			 * 
			 * }
			 * 
			 * }
			 * 
			 * datacount = new HourlyData(); HourlyData dataExitcount = new
			 * HourlyData();
			 * 
			 * datacount.setHourlyEntry(count);
			 * dataExitcount.setHourlyExit(exitcount);
			 * 
			 * if (count > 0) reportHourly1.add(datacount); if (exitcount > 0)
			 * reportHourly1.add(dataExitcount);
			 * 
			 * y++; }
			 */

			for (HourlyData hd : reportHourly1) {

				if (hd.getTimeperiod() != null)
					System.out.println(hd.getTimeperiod());

				if (hd.getEntrydt() != null && hd.getTicketid() != null) {
					System.out.println((String.format("Entry    %tc          %s  ", hd.getEntrydt(), hd.getTicketid().toString())));

				}

				if (hd.getExitdt() != null && hd.getTicketid() != null) {
					System.out.println((String.format("Exit     %tc          %s  ", hd.getExitdt(), hd.getTicketid().toString())));

				}

				if (hd.getHourlyEntry() > 0)
					System.out.println(String.format("Entry : %d   ", hd.getHourlyEntry()));

				if (hd.getHourlyExit() > 0)
					System.out.println(String.format("Exit  : %d   ", hd.getHourlyExit()));

			}

			/*
			 * for (HourlyData hd : reportHourly) {
			 * 
			 * if (hd.getExitdt() != null && hd.getTicketid() != null)
			 * System.out.println((String.format( "Exit  %tc          %s  ",
			 * hd.getExitdt(), hd .getTicketid().toString())));
			 * 
			 * System.out.print(String.format("Exit : %d   ",
			 * hd.getHourlyExit())); System.out.print("\n");
			 * 
			 * }
			 */
			// reportType = ReportType.Daily;
			// reportType = ReportType.Weekly;

			/*
			 * List<Ticket> reportData =
			 * parkingManager.getReportManagement().generateReport
			 * (reportType,parkingManager
			 * .getTicketmager().getTicketcollection(),dt);
			 * 
			 * String[] columnNames = { "TicketID", "Entry Time ", "Exit Time",
			 * "Amount" };
			 * 
			 * Object[][] data = new Object[reportData.size()][4];
			 * 
			 * for (int i = 0; i < reportData.size(); i++) { data[i][0] =
			 * reportData.get(i).getTicektID(); data[i][1] =
			 * reportData.get(i).getEntryTime(); data[i][2] =
			 * reportData.get(i).getExitTime(); data[i][3] =
			 * reportData.get(i).getTicketAmount();
			 * 
			 * }
			 * 
			 * JDialog dialog = new JDialog(); dialog.setBounds(500, 500, 800,
			 * 700); dialog.setLayout(new GridLayout());
			 * dialog.setEnabled(true); dialog.setModal(true);
			 * 
			 * dialog.getContentPane().add(new JTable(data, columnNames));
			 * 
			 * dialog.setVisible(true);
			 * 
			 * dialog.show();
			 */
		}

		if (choiceSelection == "Weekley") {

			SimpleDateFormat hrly = new SimpleDateFormat("MM/dd/yy");

			List<HourlyData> reportWeekly = new ArrayList<HourlyData>();

			List<HourlyData> exitdata = new ArrayList<HourlyData>();

			String stDate = JOptionPane.showInputDialog("Enter Week start Date Input: mm/dd/yy");

			Date dtweekStart = hrly.parse(stDate);

			String stendDate = JOptionPane.showInputDialog("Enter Week End Date Input: mm/dd/yy");

			Date dend = hrly.parse(stendDate);

			int y = 0;

			int k = 0;

			reportType = ReportType.Weekly;

			List<HourlyData> reportHourly1 = parkingManager.getTheDataCollectionforReport(reportType, dtweekStart);
		

			for (HourlyData hd : reportHourly1) {

				if (hd.getTimeperiod() != null)
					System.out.println(hd.getTimeperiod());

				if (hd.getEntrydt() != null && hd.getTicketid() != null) {
					System.out.println((String.format("Entry    %tc          %s  ", hd.getEntrydt(), hd.getTicketid().toString())));

				}

				if (hd.getExitdt() != null && hd.getTicketid() != null) {
					System.out.println((String.format("Exit     %tc          %s  ", hd.getExitdt(), hd.getTicketid().toString())));

				}

				if (hd.getHourlyEntry() > 0)
					System.out.println(String.format("Entry : %d   ", hd.getHourlyEntry()));

				if (hd.getHourlyExit() > 0)
					System.out.println(String.format("Exit  : %d   ", hd.getHourlyExit()));

			}

		}

	}

	private void textField1FocusLost(java.awt.event.FocusEvent evt) throws Exception {
		// TODO add your handling code here:
		String namePlate = "";

		if (textField1.getText() != "" && textField1.getText().length() == 6) {
			namePlate = textField1.getText();
		}

		else {
			JOptionPane.showMessageDialog(null, "Please Enter valid Name Plate");
		}

		Ticket t = parkingManager.getTheTicketFromNamePlate(namePlate);

		if (t != null) {
			jTextField10.setText(t.getTicektID().toString());
			jTextField13.setText(t.getNamePlate());
			jTextField11.setText(t.getTicektStatus().toString());
			jTextField12.setText(t.getEntryTime().toString());

		}

	}

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {

		isCashPay = false;
		isCreditpay = true;

		jTextField1.setVisible(false);

		// 170

		// jTextField4.setHorizontalAlignment(170);
		jTextField4.setVisible(true);
		jTextField6.setVisible(true);
		jTextField7.setVisible(true);

		label9.setVisible(false);

		jLabel9.setVisible(true);
		jLabel11.setVisible(true);
		jLabel12.setVisible(true);

	}

	protected void payByCashActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub

		JOptionPane.showMessageDialog(null, "Pay By cash Selected");

		isCashPay = true;
		isCreditpay = false;

		jLabel9.setVisible(false);
		label9.setVisible(true);
		jTextField4.setVisible(false);
		jTextField6.setVisible(false);
		jTextField7.setVisible(false);
		// label4.setVisible(false);
		jLabel11.setVisible(false);
		jLabel12.setVisible(false);
		jTextField1.setVisible(true);

	}

	private void checkbox1ItemStateChanged(java.awt.event.ItemEvent evt) {
		// TODO add your handling code here:
		Boolean ischecked;
		ischecked = checkbox1.getState();

		if (ischecked) {
			choice1.setVisible(false);
			label4.setVisible(false);

			// label7.setVisible(true);
			label7.setEnabled(true);

			// textField1.setVisible(true);
			textField1.setEnabled(true);
		} else {
			choice1.setVisible(true);
			label4.setVisible(true);

			textField1.setEnabled(false);
			label7.setEnabled(false);
		}

		System.out.println("Checked? " + ischecked);
	}

	private void calculatefareActionPerformed(java.awt.event.ActionEvent evt) {

		try {
			// String ticketID = null;
			// Ticket ticket = null;
			// if ((choice1.getSelectedItem().length() > 25) &&
			// (!checkbox1.getState())) {
			//
			// ticketID = choice1.getSelectedItem();
			//
			// }
			//
			// if (checkbox1.getState() && jTextField10.getText().length() > 25)
			// {
			// ticketID = jTextField10.getText();
			// }
			//
			//
			// for (Ticket t :
			// parkingManager.getTicketmager().getTicketcollection()) {
			// if (t.getTicektID().compareTo(UUID.fromString(ticketID)) == 0) {
			// ticket = t;
			// }
			// }
			//
			// parkingManager.ticket = ticket;
			//
			// parkingManager.calculateFare(parkingManager.ticket);
			//
			// label10.setText(Double.toString(parkingManager.ticket.getTicketAmount()));

			// ------------
			
			
			String ticketID= choice1.getSelectedItem();
			
			Status status = parkingManager.calculateFare(ticketID);
			label10.setText(status.getMessage());

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void IntiliazeWindows() throws RemoteException {

		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		textField2 = new java.awt.TextField();
		jLabel2 = new javax.swing.JLabel();
		jTextField2 = new javax.swing.JTextField();
		buttonPrintTicket = new javax.swing.JButton();
		buttonPayment = new javax.swing.JButton();
		buttonExit = new javax.swing.JButton();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		buttonOpenGate = new javax.swing.JButton();
		buttonClosegate = new javax.swing.JButton();
		jLabel8 = new javax.swing.JLabel();
		jTextField3 = new javax.swing.JTextField();
		jLabel9 = new javax.swing.JLabel();
		jLabel10 = new javax.swing.JLabel();
		jLabel11 = new javax.swing.JLabel();
		jLabel12 = new javax.swing.JLabel();
		jTextField4 = new javax.swing.JTextField();
		jTextField6 = new javax.swing.JTextField();
		jTextField7 = new javax.swing.JTextField();
		jLabel13 = new javax.swing.JLabel();
		jTextField8 = new javax.swing.JTextField();
		buttonFarecalc = new javax.swing.JButton();
		jTextField10 = new javax.swing.JTextField();
		jTextField11 = new javax.swing.JTextField();
		jTextField12 = new javax.swing.JTextField();
		label2 = new java.awt.Label();
		label3 = new java.awt.Label();
		choice1 = new java.awt.Choice();
		label4 = new java.awt.Label();
		label5 = new java.awt.Label();
		label6 = new java.awt.Label();
		buttonGate1 = new javax.swing.JButton();
		buttonGate2 = new javax.swing.JButton();
		buttonGate3 = new javax.swing.JButton();
		jLabel14 = new javax.swing.JLabel();
		jLabel15 = new javax.swing.JLabel();
		choiseReport = new java.awt.Choice();
		btnReport = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		jButton4 = new javax.swing.JButton();
		label1 = new java.awt.Label();
		jTextField13 = new javax.swing.JTextField();
		textField1 = new java.awt.TextField();
		label7 = new java.awt.Label();
		label8 = new java.awt.Label();
		checkbox1 = new java.awt.Checkbox();
		jTextField1 = new javax.swing.JTextField();
		label9 = new java.awt.Label();
		label10 = new java.awt.Label();
		jButton5 = new javax.swing.JButton();
		textField3 = new java.awt.TextField();
		label11 = new java.awt.Label();
		checkbox2 = new java.awt.Checkbox();
		jButton6 = new javax.swing.JButton();

		jButton1.setText("jButton1");

		jButton2.setText("jButton2");

		textField2.setText("textField2");

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setBackground(new java.awt.Color(204, 255, 204));
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosed(java.awt.event.WindowEvent evt) {
				formWindowClosed(evt);
			}
		});

		jLabel2.setText("Parking Status");

		buttonPrintTicket.setText("Prints Ticket");
		buttonPrintTicket.setToolTipText("");
		buttonPrintTicket.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {

				printTicketActionPerformed(evt);

			}
		});

		buttonPayment.setText("Payment");
		buttonPayment.setToolTipText("");
		buttonPayment.setActionCommand("Pay");
		buttonPayment.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				paymentActionPerformed(evt);
			}
		});

		buttonExit.setText("Exit  Gate");
		buttonExit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				exitActionPerformed(evt);
			}
		});

		jLabel4.setBackground(new java.awt.Color(102, 102, 102));
		jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel4.setText("Ticket Status");

		jLabel5.setText("Ticket ID");
		jLabel5.setToolTipText("");

		jLabel6.setText("Status");

		jLabel7.setText("Entry Time");

		buttonOpenGate.setText("Open Gate");
		buttonOpenGate.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				openGateActionPerformed(evt);
			}
		});

		buttonClosegate.setText("Close Gate");
		buttonClosegate.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				closeGateActionPerformed(evt);
			}
		});

		jLabel8.setText("Gate Status");

		jLabel9.setText("Credit Card Number");

		jLabel10.setText("Amount");
		jLabel10.setToolTipText("");

		jLabel11.setText("Enter Expiry (MM/yyyy)");

		jLabel12.setText("CVV");

		jLabel13.setText("Payment Status");

		buttonFarecalc.setText("Calculate Fare");
		buttonFarecalc.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				calculatefareActionPerformed(evt);
			}
		});

		jTextField10.setToolTipText("");
		jTextField10.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField10ActionPerformed(evt);
			}
		});

		jTextField11.setToolTipText("");

		jTextField12.setToolTipText("");

		label2.setAlignment(java.awt.Label.CENTER);
		label2.setBackground(new java.awt.Color(255, 255, 51));
		label2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
		label2.setText("Exiting ");

		label3.setText("Select TicketID");
		label3.setVisible(false);

		choice1.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				choice1ItemStateChanged(evt);
			}
		});

		label4.setText("Select TicketID");

		label5.setAlignment(java.awt.Label.CENTER);
		label5.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N

		label6.setName(""); // NOI18N
		label6.setText("Parking Count");

		buttonGate1.setText("Gate1");
		buttonGate1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					buttonGate1ActionPerformed(evt);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		buttonGate2.setText("Gate2");
		buttonGate2.setToolTipText("");
		buttonGate2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					buttonGate2ActionPerformed(evt);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		buttonGate3.setText("Gate3");
		buttonGate3.setToolTipText("");
		buttonGate3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					buttonGate3ActionPerformed(evt);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		jLabel14.setText("Select Entry gate");
		jLabel14.setToolTipText("");

		jLabel15.setText("Reports");

		btnReport.setText("View Report");
		btnReport.setToolTipText("");
		btnReport.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					ReportActionPerformed(evt);
				} catch (RemoteException | ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		jButton3.setText("Pay by CreditCard");
		jButton3.setToolTipText("");
		jButton3.setActionCommand("");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});

		jButton4.setText("Pay By Cash");
		jButton4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				payByCashActionPerformed(evt);
			}
		});

		label1.setName(""); // NOI18N
		label1.setText("Name Plate");

		jTextField13.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				// jTextField13ActionPerformed(evt);
			}
		});

		textField1.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusLost(java.awt.event.FocusEvent evt) {
				try {
					textField1FocusLost(evt);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		label7.setName(""); // NOI18N
		label7.setText("Enter PlateID");

		label8.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
		label8.setText("Forgot Ticket ?");

		checkbox1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
		checkbox1.setLabel("Yes");
		checkbox1.setName(""); // NOI18N
		checkbox1.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				checkbox1ItemStateChanged(evt);
			}
		});

		jTextField1.setToolTipText("");

		label9.setText("Amount");

		label10.setName(""); // NOI18N
		label10.setText("0.00");

		jButton5.setText("View Collection");
		jButton5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					jButton5ActionPerformed(evt);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		label11.setText("Scan Ticket for Exit");

		checkbox2.setLabel("Change Date/Time?");
		checkbox2.setName(""); // NOI18N
		checkbox2.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				checkbox2ItemStateChanged(evt);
			}
		});

		jButton6.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
		jButton6.setText("Change Date/Time");
		jButton6.setToolTipText("");

		jButton6.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					jButton6ActionPerformed(evt);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(32, 32, 32)
								.addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
												.addComponent(label7, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(label9, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel6)
												.addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 103,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel9)
												.addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 107,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 145,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 116,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(label11, javax.swing.GroupLayout.PREFERRED_SIZE, 131,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel13)
												.addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, 131,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 106,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(10, 10, 10)
								.addGroup(
										layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														javax.swing.GroupLayout.Alignment.TRAILING,
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING)
																				.addComponent(buttonPrintTicket,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(buttonGate1)
																								.addGap(42, 42, 42)
																								.addComponent(buttonGate2)
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										Short.MAX_VALUE)
																								.addComponent(buttonGate3))
																				.addComponent(choice1,
																						javax.swing.GroupLayout.Alignment.LEADING,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE)).addGap(41, 41, 41))
												.addGroup(
														javax.swing.GroupLayout.Alignment.TRAILING,
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(jTextField13,
																						javax.swing.GroupLayout.PREFERRED_SIZE, 121,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addGroup(
																						layout.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING)
																								.addGroup(
																										layout.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.LEADING)
																												.addComponent(
																														textField1,
																														javax.swing.GroupLayout.PREFERRED_SIZE,
																														185,
																														javax.swing.GroupLayout.PREFERRED_SIZE)
																												.addGroup(
																														layout.createSequentialGroup()
																																.addComponent(
																																		jButton3,
																																		javax.swing.GroupLayout.PREFERRED_SIZE,
																																		153,
																																		javax.swing.GroupLayout.PREFERRED_SIZE)
																																.addPreferredGap(
																																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																																.addComponent(
																																		jButton4,
																																		javax.swing.GroupLayout.PREFERRED_SIZE,
																																		149,
																																		javax.swing.GroupLayout.PREFERRED_SIZE))
																												.addComponent(
																														textField3,
																														javax.swing.GroupLayout.PREFERRED_SIZE,
																														293,
																														javax.swing.GroupLayout.PREFERRED_SIZE)
																												.addComponent(
																														label10,
																														javax.swing.GroupLayout.PREFERRED_SIZE,
																														122,
																														javax.swing.GroupLayout.PREFERRED_SIZE)
																												.addComponent(
																														buttonFarecalc,
																														javax.swing.GroupLayout.PREFERRED_SIZE,
																														224,
																														javax.swing.GroupLayout.PREFERRED_SIZE))
																								.addComponent(
																										jTextField4,
																										javax.swing.GroupLayout.Alignment.LEADING,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										249,
																										javax.swing.GroupLayout.PREFERRED_SIZE)
																								.addGroup(
																										javax.swing.GroupLayout.Alignment.LEADING,
																										layout.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.TRAILING,
																												false)
																												.addComponent(
																														jTextField7,
																														javax.swing.GroupLayout.Alignment.LEADING,
																														javax.swing.GroupLayout.DEFAULT_SIZE,
																														130,
																														Short.MAX_VALUE)
																												.addComponent(
																														jTextField6,
																														javax.swing.GroupLayout.Alignment.LEADING)
																												.addComponent(
																														jTextField1,
																														javax.swing.GroupLayout.Alignment.LEADING,
																														javax.swing.GroupLayout.DEFAULT_SIZE,
																														130,
																														Short.MAX_VALUE)))
																				.addGroup(
																						layout.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING,
																								false)
																								.addComponent(
																										jTextField11,
																										javax.swing.GroupLayout.Alignment.LEADING,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										280, Short.MAX_VALUE)
																								.addComponent(
																										jTextField10,
																										javax.swing.GroupLayout.Alignment.LEADING))
																				.addComponent(jTextField8,
																						javax.swing.GroupLayout.PREFERRED_SIZE, 281,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(jTextField12,
																						javax.swing.GroupLayout.PREFERRED_SIZE, 271,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																.addGap(28, 28, 28))
												.addGroup(
														javax.swing.GroupLayout.Alignment.TRAILING,
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addGap(0, 3, Short.MAX_VALUE)
																								.addComponent(
																										label2,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										286,
																										javax.swing.GroupLayout.PREFERRED_SIZE))
																				.addGroup(
																						javax.swing.GroupLayout.Alignment.LEADING,
																						layout.createSequentialGroup()
																								.addComponent(
																										label8,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										Short.MAX_VALUE)
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																								.addComponent(
																										checkbox1,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										164,
																										javax.swing.GroupLayout.PREFERRED_SIZE)))
																.addGap(50, 50, 50))
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(buttonPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 206,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																		javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(jLabel4,
																						javax.swing.GroupLayout.PREFERRED_SIZE, 272,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(
																										buttonOpenGate,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										144,
																										javax.swing.GroupLayout.PREFERRED_SIZE)
																								.addGap(26, 26, 26)
																								.addComponent(
																										buttonClosegate,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										122,
																										javax.swing.GroupLayout.PREFERRED_SIZE))
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(
																										checkbox2,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										132,
																										javax.swing.GroupLayout.PREFERRED_SIZE)
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																								.addComponent(
																										jButton6,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										132,
																										javax.swing.GroupLayout.PREFERRED_SIZE)))
																.addGap(0, 0, Short.MAX_VALUE)))
								.addGroup(
										layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(jLabel8,
																						javax.swing.GroupLayout.PREFERRED_SIZE, 81,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(jTextField3,
																						javax.swing.GroupLayout.PREFERRED_SIZE, 98,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(jLabel2)
																				.addComponent(jTextField2,
																						javax.swing.GroupLayout.PREFERRED_SIZE, 105,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(label6,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(choiseReport,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addGroup(
																						layout.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING,
																								false)
																								.addComponent(
																										jButton5,
																										javax.swing.GroupLayout.Alignment.LEADING,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										Short.MAX_VALUE)
																								.addComponent(
																										btnReport,
																										javax.swing.GroupLayout.Alignment.LEADING,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										Short.MAX_VALUE))
																				.addComponent(label5,
																						javax.swing.GroupLayout.PREFERRED_SIZE, 72,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																.addGap(0, 5, Short.MAX_VALUE))))
				.addGroup(
						layout.createSequentialGroup()
								.addGroup(
										layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(layout.createSequentialGroup().addGap(32, 32, 32).addComponent(jLabel12))
												.addGroup(layout.createSequentialGroup().addGap(193, 193, 193).addComponent(jLabel3))
												.addGroup(
														layout.createSequentialGroup()
																.addGap(262, 262, 262)
																.addComponent(buttonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 103,
																		javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addGap(0, 0, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																				.addComponent(buttonGate3,
																						javax.swing.GroupLayout.PREFERRED_SIZE, 30,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(buttonGate2,
																						javax.swing.GroupLayout.PREFERRED_SIZE, 30,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(buttonGate1,
																						javax.swing.GroupLayout.PREFERRED_SIZE, 30,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(jLabel14))
																.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(buttonPrintTicket)
																.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 16,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20,
																		Short.MAX_VALUE))
												.addGroup(
														layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addComponent(jLabel2)
																.addGap(16, 16, 16)))
								.addGroup(
										layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(choice1, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
								.addComponent(jLabel3)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel5)
												.addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(
										layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(jTextField13,
																						javax.swing.GroupLayout.Alignment.TRAILING,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(label1,
																						javax.swing.GroupLayout.Alignment.TRAILING,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																				.addComponent(jLabel6)
																				.addComponent(jTextField11,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																				.addComponent(jLabel7)
																				.addComponent(jTextField12,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING)
																				.addComponent(checkbox2,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(jButton6)).addGap(4, 4, 4))
												.addComponent(label5, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(
										layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														javax.swing.GroupLayout.Alignment.TRAILING,
														layout.createSequentialGroup()
																.addGap(61, 71, Short.MAX_VALUE)
																.addComponent(jLabel8)
																.addGap(28, 28, 28)
																.addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGroup(
														layout.createSequentialGroup()
																.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addGroup(
																										layout.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.BASELINE)
																												.addComponent(
																														buttonOpenGate)
																												.addComponent(
																														buttonClosegate))
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																								.addComponent(
																										label2,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										javax.swing.GroupLayout.PREFERRED_SIZE)
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										Short.MAX_VALUE)
																								.addGroup(
																										layout.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.LEADING)
																												.addComponent(
																														checkbox1,
																														javax.swing.GroupLayout.Alignment.TRAILING,
																														javax.swing.GroupLayout.PREFERRED_SIZE,
																														javax.swing.GroupLayout.DEFAULT_SIZE,
																														javax.swing.GroupLayout.PREFERRED_SIZE)
																												.addComponent(
																														label8,
																														javax.swing.GroupLayout.Alignment.TRAILING,
																														javax.swing.GroupLayout.PREFERRED_SIZE,
																														javax.swing.GroupLayout.DEFAULT_SIZE,
																														javax.swing.GroupLayout.PREFERRED_SIZE))
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																								.addComponent(
																										textField1,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										javax.swing.GroupLayout.PREFERRED_SIZE))
																				.addGroup(
																						layout.createSequentialGroup()
																								.addGap(0, 0, Short.MAX_VALUE)
																								.addComponent(
																										label7,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										javax.swing.GroupLayout.PREFERRED_SIZE)))))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(textField3, javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(buttonFarecalc)
																.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(jButton3)
																				.addComponent(jButton4,
																						javax.swing.GroupLayout.Alignment.TRAILING))
																.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																				.addComponent(jTextField4,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(jLabel9))
																.addGap(11, 11, 11)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING, false)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(
																										label10,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										javax.swing.GroupLayout.PREFERRED_SIZE)
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																								.addComponent(
																										jTextField1,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										javax.swing.GroupLayout.PREFERRED_SIZE))
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(jLabel10)
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										Short.MAX_VALUE)
																								.addComponent(
																										label9,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										javax.swing.GroupLayout.PREFERRED_SIZE)))
																.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																				.addComponent(jTextField6,
																						javax.swing.GroupLayout.PREFERRED_SIZE, 20,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(jLabel11))
																.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																				.addComponent(jLabel12)
																				.addComponent(jTextField7,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19,
																		Short.MAX_VALUE)
																.addComponent(buttonPayment)
																.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																				.addComponent(jTextField8,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(jLabel13)))
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(label11, javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(102, 102, 102)
																.addComponent(jLabel15)
																.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(choiseReport, javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE).addGap(21, 21, 21)
																.addComponent(btnReport).addGap(18, 18, 18).addComponent(jButton5)))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
								.addComponent(buttonExit).addGap(19, 19, 19)));

		jLabel3.getAccessibleContext().setAccessibleName("lblprintTicket");
		jLabel4.getAccessibleContext().setAccessibleName("lblticketid");
		jLabel5.getAccessibleContext().setAccessibleName("lblticketID");
		jLabel6.getAccessibleContext().setAccessibleName("lblticketInTime");
		jLabel7.getAccessibleContext().setAccessibleName("lblticketStatus");
		textField1.getAccessibleContext().setAccessibleName("");
		label10.getAccessibleContext().setAccessibleName("");

		textField1.getAccessibleContext().setAccessibleName("");
		label10.getAccessibleContext().setAccessibleName("");

		textField1.getAccessibleContext().setAccessibleName("");
		label10.getAccessibleContext().setAccessibleName("");

		textField1.setEnabled(false);

		jButton6.setEnabled(false);

		label7.setName(""); // NOI18N
		label7.setText("Enter PlateID");

		label7.setEnabled(false);

		textField1.setText("");

		label7.setText("Enter PlateID");
		label7.setEnabled(false);

		// if(checkbox1.getState())
		// {
		// label7.setVisible(true);
		// textField1.setVisible(true);
		// }
		// else
		{
			// label7.setVisible(false);
			// textField1.setVisible(false);
		}

		choiseReport.add("Hourly");
		choiseReport.add("Daily");
		choiseReport.add("Weekley");
		choiseReport.add("Monthly");

		jTextField3.setText(GateStatus.Close.toString());

		ParkingStatus parkingStatus = parkingManager.getTheCurrentparkingStatus();

		jTextField2.setText(parkingStatus.toString());

		choice1.addItemListener(new java.awt.event.ItemListener() {

			public void itemStateChanged(java.awt.event.ItemEvent evt) {

				try {
					choise1ItemStateChanged(evt);
				} catch (Exception e) {

					e.printStackTrace();
				}
			}

		});

	}

	protected void choise1ItemStateChanged(ItemEvent evt) throws Exception {

		JOptionPane.showMessageDialog(null, "Ticket selcted    :   " + choice1.getSelectedItem());

		jTextField4.setText("");
		label10.setText("");
		jTextField1.setText("");
		jTextField6.setText("");
		jTextField7.setText("");
		jTextField8.setText("");

		jTextField10.setText("");
		jTextField13.setText("");
		jTextField11.setText("");
		jTextField12.setText("");

		Ticket t = parkingManager.getTheTicketfromID(choice1.getSelectedItem());

		if (t != null) {
			jTextField10.setText(t.getTicektID().toString());
			jTextField13.setText(t.getNamePlate());
			jTextField11.setText(t.getTicektStatus().toString());
			jTextField12.setText(t.getEntryTime().toString());

		}
	}

	protected void formWindowClosed(WindowEvent evt) {
		// TODO Auto-generated method stub

	}

	protected void jTextField10ActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub

	}

	protected void jTextField5ActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub

	}

	private static int getIntValue(String input, int defaultValue) {

		int value = 0;
		try {
			value = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			value = defaultValue;
		}
		return value;
	}

	public static void main(String[] args) throws InterruptedException, RemoteException, MalformedURLException, NotBoundException {

		IparkingSystemManager iparkingSystemManager = null;
		parkingGUI objgui = null;

		if (args.length != 4) {
			String message = "Remote Server IP, port, parking capacity and hourly rate is mandatory";
			System.out.println(message);
			System.exit(0);
		}

		// p = new ParkingSystemManager();
		iparkingSystemManager = (IparkingSystemManager) Naming.lookup("rmi://" + args[0] + ":" + args[1] + "/ParkingService");

		System.out.println("Remote reference obtained.");

		objgui = new parkingGUI();
		objgui.parkingManager = iparkingSystemManager;

		objgui.parkingManager.initialize(getIntValue(args[2], 10), getIntValue(args[3], 60));
		System.out.println("ParkingService server  is running.....");

		// Ensure the gatestatus
		if (objgui != null) {
			objgui.IntiliazeWindows();

			objgui.setSize(675, 865);//

			objgui.show();
		}

	}

}
