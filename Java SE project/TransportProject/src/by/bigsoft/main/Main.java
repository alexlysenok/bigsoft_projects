package by.bigsoft.main;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import by.bigsoft.logiticcenter.*;
import by.bigsoft.city.City;
import by.bigsoft.dataimport.DataImportHardcode;
import by.bigsoft.dataimport.DataImportXML;
import by.bigsoft.dataimport.IDataImport;

import by.bigsoft.logiticcenter.*;
import by.bigsoft.transport.*;

import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Main {
	private static City selectedStartCity;
	private static City selectedEndCity;
	private static  LogisticCenter lc;
	private static ArrayList<JButton> startCityButtonsList;
	private static ArrayList<JButton> endCityButtonsList;
	private static JButton but3;

	public static void main(String[] args) throws Exception, NumberFormatException {
		

		JFrame window = new JFrame("����� ������� �������� ������");
		window.setBounds(700, 300, 360, 170);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton but1 = new JButton("�������");
		but1.setBounds(90, 40, 180, 30);
		but1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IDataImport dI = new DataImportHardcode();

				try {
					lc = new LogisticCenter(dI);
				} catch (Exception e2) {
					e2.printStackTrace();
				}

				try {
                    
					City start = new City("���������", 52.3740300, 4.8896900, true, true, true);
					City end = new City("����", 59.9127300, 10.7460900, true, true, true);
					int passengers = Integer.parseInt(JOptionPane.showInputDialog("������� ���-�� ����������: (�� 1 �� ...)"));
					double cargo = Double.parseDouble(JOptionPane.showInputDialog("������� ���-�� �����: (�� 0,0...1 �� ...)"));
					double price1,dist,price=0;
					price1=lc.getTheCheapestTransport(start, end, passengers, cargo).getPricePerKM();
					dist=lc.calculateDistance(start,end,false);
					price=dist*price1;
					String str2 = ('\n'+ "����� ������� ��� ����������: "+ lc.getTheCheapestTransport(start, end,passengers, cargo).getName()+ 
							"________________���� ����������: "+ price + "$");
					String str3 = ("����� ������� ��� ����������: "
							+ lc.getTheFastestTransport(start, end, passengers,
									cargo).getName()
							+ "_______________������� c������� ����������: "
							+ lc.getTheFastestTransport(start, end, passengers,
									cargo).getSpeed() + " ��/�");
					JOptionPane.showMessageDialog(null,
							lc.resultConsole(start, end, passengers, cargo)+ '\n'+ "*************************************************"
									+ str2 + '\n' + str3);

				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});

		JButton XMLButton = new JButton("�������� �� �ml");
		XMLButton.setBounds(90, 70, 180, 30);
		XMLButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IDataImport dI = new DataImportXML();

				try {
					lc = new LogisticCenter(dI);
				} catch (Exception e1) {
					e1.printStackTrace();
				}

				try {
                   
					startCityButtonsList = new ArrayList<JButton>();
					endCityButtonsList = new ArrayList<JButton>();
					final List<City> citiesFinalList = lc.createCities();

					JFrame window2 = new JFrame("�������� �����");
					window2.setBounds(700, 300, 680, 500);
					window2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					window2.setLayout(null);
					window2.setVisible(true);
					JLabel label1 = new JLabel("�������� ����� ��������: ");
					label1.setBounds(90, 15, 180, 15);
					JLabel label2 = new JLabel("�������� ����� ����������: ");
					label2.setBounds(380, 15, 180, 15);
					for (int i = 0, j = 40; i < lc.createCities().size(); i++, j += 40) {
						final int index = i;
						final City start = citiesFinalList.get(i);
						JButton but = new JButton(lc.createCities().get(i)
								.getName());
						but.setBounds(90, j, 180, 30);
						but.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								selectedStartCity = start;
								colourStartCityButton(index);
							}
						});
						but.setBackground(Color.LIGHT_GRAY);
						window2.add(but);
						window2.add(label1);
						window2.add(label2);
						startCityButtonsList.add(but);
					}

					for (int i = 0, j = 40; i < lc.createCities().size(); i++, j += 40) {
						final int index = i;
						final City end = citiesFinalList.get(i);
						JButton but = new JButton(lc.createCities().get(i)
								.getName());
						but.setBounds(380, j, 180, 30);
						but.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								selectedEndCity = end;
								colourEndCityButton(index);
							}
						});
						but.setBackground(Color.LIGHT_GRAY);
						window2.add(but);
						endCityButtonsList.add(but);
					}

					but3 = new JButton("�������");
					but3.setBounds(235, 400, 180, 30);
					but3.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if (selectedStartCity != null
									&& selectedEndCity != null) {
								if (selectedStartCity == selectedEndCity) {
									JOptionPane
											.showMessageDialog(null, "������ �������� ���������� ������");
								} else {
									colourButton();
									int passengers = 0;
									double cargo = 0;
									
									try{
									passengers = Integer.parseInt(JOptionPane
											.showInputDialog("������� ���-�� ����������: (�� 1 �� ...)"));
									cargo = Double.parseDouble(JOptionPane
											.showInputDialog("������� ���-�� �����: (�� 0,0...1 �� ...)"));
									}catch (NumberFormatException e1) {
						
						                e1.printStackTrace();
										JOptionPane.showMessageDialog(null,"������������ ������ �����, ���������� ���");
									} finally{
									if (passengers == 0 || cargo == 0 || passengers < 0 || cargo < 0) {
										JOptionPane
												.showMessageDialog(null,
														"������������ ������ ������, ������� ������");
									} else {
										double price1,dist,price=0;
										price1=lc.getTheCheapestTransport(selectedStartCity, selectedEndCity, passengers, cargo).getPricePerKM();
										dist=lc.calculateDistance(selectedStartCity,selectedEndCity,false);
										price=dist*price1;
										String str2 = ('\n'
												+ "����� ������� ��� ����������: "
												+ lc.getTheCheapestTransport(
														selectedStartCity,
														selectedEndCity,
														passengers, cargo)
														.getName()
												+ "________________���� ����������: "
												+ price + "$");
										String str3 = ("����� ������� ��� ����������: "
												+ lc.getTheFastestTransport(
														selectedStartCity,
														selectedEndCity,
														passengers, cargo)
														.getName()
												+ "________________������� c������� ����������: "
												+ lc.getTheFastestTransport(
														selectedStartCity,
														selectedEndCity,
														passengers, cargo)
														.getSpeed() + " ��/�");
										JOptionPane.showMessageDialog(
												null,
												lc.resultConsole(
														selectedStartCity,
														selectedEndCity,
														passengers, cargo)+ '\n'+ "*************************************************"
														+ str2 + '\n' + str3);

									}
								}
							}} else {
								JOptionPane
										.showMessageDialog(null,
												"�������� ����� �������� � ����� ����������");
							}

						}
					});

					window2.add(but3);
					but3.setBackground(Color.LIGHT_GRAY);

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		window.setLayout(null);
		window.add(but1);
		window.add(XMLButton);
		window.setVisible(true);

	}

	public static void colourStartCityButton(int index) {
		for (int i = 0; i < startCityButtonsList.size(); i++) {
			startCityButtonsList.get(i).setBackground(Color.LIGHT_GRAY);
		}
		startCityButtonsList.get(index).setBackground(Color.ORANGE);
	}

	public static void colourEndCityButton(int index) {
		for (int i = 0; i < endCityButtonsList.size(); i++) {
			endCityButtonsList.get(i).setBackground(Color.LIGHT_GRAY);
		}
		endCityButtonsList.get(index).setBackground(Color.ORANGE);
	}

	public static void colourButton() {
		but3.setBackground(Color.ORANGE);
	}
}
