package com.mtz.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.Timer;
import java.util.TimerTask;

import com.mtz.dao.MTZDao;
import com.mtz.po.MTZ;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class RunController {
	MTZDao dao = new MTZDao();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd HH:mm");
	@FXML
	private Label grade;
	private static int gradeNum = 0;
	@FXML
	private Label time;
	private static final int timeNum2 = 180;
	private static int timeNum = 180;
	@FXML
	private ImageView zha1;//
	@FXML
	private ImageView zha2;// �����¼�����Ҫ��
	@FXML
	private ImageView jin1;// �����¼�����Ҫ��
	@FXML
	private ImageView jin2;// �����¼�����Ҫ��
	@FXML
	private TextField aaa;// �����¼�����Ҫ��
	@FXML
	private ImageView success;
	@FXML
	private Pane runPane;
	@FXML
	private ImageView carImage;// ��ͼ ���184
	// ��Ϸ�е�����
	String file = MainController.class.getResource("/com/mtz/music/ing.mp3")
			.toString();
	Media media = new Media(file);
	MediaPlayer mpIng = new MediaPlayer(media);
	
	// ��Ϸ����������
	String file2 = MainController.class.getResource("/com/mtz/music/Stop.mp3")
			.toString();
	Media media2 = new Media(file2);
	MediaPlayer mpstorp = new MediaPlayer(media2);
	private static int change = 1; // ����ͼƬ����Ķ�̬ͼ
	private static int change2 = 5; // ����ͼƬ����Ķ�̬ͼ
	private static Boolean flag = false;
	// ��ʱ��
	Timer timer = new Timer();
	TimerTask Image4Timer = new TimerTask() {
		@Override
		public void run() {
			Platform.runLater(new Runnable() {
				public void run() {
					if (true) {
						Double ZanX = zha1.getX();
						Double ZanW = zha1.getFitWidth();
						Double ZanY = zha1.getY();
						Double ZanH = zha1.getFitHeight();
						Double CarX = carImage.getX();
						Double CarW = carImage.getFitWidth();
						Double CarY = carImage.getY();
						Double CarH = carImage.getFitHeight();
						if ((((ZanX + ZanW - 10) > CarX) && (ZanX < (CarX
								+ CarW - 16)))
								&& (((ZanY + ZanH) + 0 > CarY) && (ZanY < (CarY
										+ CarH - 50)))) {
							mpIng.stop();
							Image4Timer.cancel();
							mytimer.cancel();
							int dbgrade=Integer.parseInt(grade.getText());
							String dbtime=sdf.format(new Date());
							String dbstage = "1";
							MTZ mtz = new MTZ(dbtime, dbgrade, dbstage);
							dao.addMtz(mtz);
							timeNum= timeNum2;
							gradeNum=0;
							Alert alert = new Alert(AlertType.CONFIRMATION);
							alert.setTitle("��ʾ");
							alert.setHeaderText("��Ϸʧ��,�ص���ҳ��");
							Optional<ButtonType> result = alert.showAndWait();
							if (result.get() == ButtonType.OK) {
								mpstorp.stop();
								try {
									Parent root = FXMLLoader
											.load(getClass().getResource(
													"/com/mtz/view/Main.fxml"));
									Scene scene = new Scene(root);
									Stage stage = new Stage();
									stage.initStyle(StageStyle.DECORATED);
									stage.setScene(scene);
									stage.setTitle("��ʼ��Ϸ");
									stage.show();
									scene.getStylesheets().add(
											getClass().getResource(
													"/com/mtz/main/main.css")
													.toExternalForm());
									time.getScene().getWindow().hide();
								} catch (IOException e) {
									System.out.println(e.getMessage());
								}
							} else {
								System.exit(0);
							}
						}
					}
					if (true) {
						Double ZanX = zha2.getX();
						Double ZanW = zha2.getFitWidth();
						Double ZanY = zha2.getY();
						Double ZanH = zha2.getFitHeight();
						Double CarX = carImage.getX();
						Double CarW = carImage.getFitWidth();
						Double CarY = carImage.getY();
						Double CarH = carImage.getFitHeight();
						if ((((ZanX + ZanW - 10) > CarX) && (ZanX < (CarX
								+ CarW - 16)))
								&& (((ZanY + ZanH) + 0 > CarY) && (ZanY < (CarY
										+ CarH - 50)))) {
							mpIng.stop();
							Image4Timer.cancel();
							mytimer.cancel();
							int dbgrade=Integer.parseInt(grade.getText());
							String dbtime=sdf.format(new Date());
							String dbstage = "1";
							MTZ mtz = new MTZ(dbtime, dbgrade, dbstage);
							dao.addMtz(mtz);
							timeNum= timeNum2;
							timeNum= timeNum2;
							gradeNum=0;
							Alert alert = new Alert(AlertType.CONFIRMATION);
							alert.setTitle("��ʾ");
							alert.setHeaderText("��Ϸʧ��,�ص���ҳ��");
							Optional<ButtonType> result = alert.showAndWait();
							if (result.get() == ButtonType.OK) {
								mpstorp.stop();
								try {
									Parent root = FXMLLoader
											.load(getClass().getResource(
													"/com/mtz/view/Main.fxml"));
									Scene scene = new Scene(root);
									Stage stage = new Stage();
									stage.initStyle(StageStyle.DECORATED);
									stage.setScene(scene);
									stage.setTitle("��ʼ��Ϸ");
									stage.show();
									scene.getStylesheets().add(
											getClass().getResource(
													"/com/mtz/main/main.css")
													.toExternalForm());
									time.getScene().getWindow().hide();
								} catch (IOException e) {
									System.out.println(e.getMessage());
								}
							} else {
								System.exit(0);
							}
						}
					}
					if (true) {
						Double ZanX = jin1.getX();
						Double ZanW = jin1.getFitWidth();
						Double ZanY = jin1.getY();
						Double ZanH = jin1.getFitHeight();
						Double CarX = carImage.getX();
						Double CarW = carImage.getFitWidth();
						Double CarY = carImage.getY();
						Double CarH = carImage.getFitHeight();
						if ((((ZanX + ZanW - 10) > CarX) && (ZanX < (CarX
								+ CarW - 16)))
								&& (((ZanY + ZanH) + 0 > CarY) && (ZanY < (CarY
										+ CarH - 50)))) {
							gradeNum=gradeNum+100;
							grade.setText(gradeNum+"");
							MediaPlayer mpstorp = new MediaPlayer(media2);
							mpstorp.play();
							jin1.setY(50 + Math.random() * 320);
							jin1.setX(50 + Math.random() * 320);
						}
					}
					if (true) {
						Double ZanX = jin2.getX();
						Double ZanW = jin2.getFitWidth();
						Double ZanY = jin2.getY();
						Double ZanH = jin2.getFitHeight();
						Double CarX = carImage.getX();
						Double CarW = carImage.getFitWidth();
						Double CarY = carImage.getY();
						Double CarH = carImage.getFitHeight();
						if ((((ZanX + ZanW - 10) > CarX) && (ZanX < (CarX
								+ CarW - 16)))
								&& (((ZanY + ZanH) + 0 > CarY) && (ZanY < (CarY
										+ CarH - 50)))) {
							gradeNum=gradeNum+100;
							grade.setText(gradeNum+"");
							MediaPlayer mpstorp = new MediaPlayer(media2);
							mpstorp.play();
							jin2.setY(50 + Math.random() * 320);
							jin2.setX(50 + Math.random() * 320);
						}
					}
					if (true) {
						Double ZanX = success.getX();
						Double ZanW = success.getFitWidth();
						Double ZanY = success.getY();
						Double ZanH = success.getFitHeight();
						Double CarX = carImage.getX();
						Double CarW = carImage.getFitWidth();
						Double CarY = carImage.getY();
						Double CarH = carImage.getFitHeight();
						if ((((ZanX + ZanW - 10) > CarX) && (ZanX < (CarX
								+ CarW - 16)))
								&& (((ZanY + ZanH) + 0 > CarY) && (ZanY < (CarY
										+ CarH - 50)))) {
							mpIng.stop();
							Image4Timer.cancel();
							mytimer.cancel();
							int dbgrade=Integer.parseInt(grade.getText());
							String dbtime=sdf.format(new Date());
							String dbstage = "0";
							MTZ mtz = new MTZ(dbtime, dbgrade, dbstage);
							dao.addMtz(mtz);
							timeNum= timeNum2;
							gradeNum=0;
							Alert alert = new Alert(AlertType.CONFIRMATION);
							alert.setTitle("��ʾ");
							alert.setHeaderText("��Ϸ�ɹ�,�ص���ҳ��");
							Optional<ButtonType> result = alert.showAndWait();
							if (result.get() == ButtonType.OK) {
								mpstorp.stop();
								try {
									Parent root = FXMLLoader
											.load(getClass().getResource(
													"/com/mtz/view/Main.fxml"));
									Scene scene = new Scene(root);
									Stage stage = new Stage();
									stage.initStyle(StageStyle.DECORATED);
									stage.setScene(scene);
									stage.setTitle("��ʼ��Ϸ");
									stage.show();
									scene.getStylesheets().add(
											getClass().getResource(
													"/com/mtz/main/main.css")
													.toExternalForm());
									time.getScene().getWindow().hide();
								} catch (IOException e) {
									System.out.println(e.getMessage());
								}
							} else {
								System.exit(0);
							}
						}
					}


				}
			});

		}
	};

	// ʱ�䵽�� ����Ϸʤ��
	TimerTask mytimer = new TimerTask() {
		public void run() {
			Platform.runLater(new Runnable() {
				public void run() {
					time.setText(timeNum + "");
					timeNum--;
					if (timeNum == 0) {
						mpIng.stop();
						mytimer.cancel();
						Image4Timer.cancel();
						int dbgrade=Integer.parseInt(grade.getText());
						String dbtime=sdf.format(new Date());
						String dbstage = "1";
						MTZ mtz = new MTZ(dbtime, dbgrade, dbstage);
						dao.addMtz(mtz);
						mpIng.stop();
						time.setText(0 + "");
						timeNum = timeNum2;
						gradeNum=0;
						Alert alert = new Alert(AlertType.CONFIRMATION);
						alert.setTitle("��ʾ");
						alert.setHeaderText("ʱ�䵽����Ϸʧ��,�ص���ҳ��");
						Optional<ButtonType> result = alert.showAndWait();
						if (result.get() == ButtonType.OK) {
							try {
								Parent root = FXMLLoader
										.load(getClass().getResource(
												"/com/mtz/view/Main.fxml"));
								Scene scene = new Scene(root);
								Stage stage = new Stage();
								stage.initStyle(StageStyle.DECORATED);
								stage.setScene(scene);
								stage.setTitle("��ʼ��Ϸ");
								stage.show();
								scene.getStylesheets().add(
										getClass().getResource(
												"/com/mtz/main/main.css")
												.toExternalForm());
								time.getScene().getWindow().hide();
							} catch (IOException e) {
								System.out.println(e.getMessage());
							}
						} else {
							System.exit(0);
						}
					}
				}
			});
		}
	};

	public void initialize() {
		inin();
	}

	public void inin() {
		mpIng.play();
		TimeTimer();
		success.setX(562);
		success.setY(369);
		carImage.setY(10);
		aaa.requestFocus();
		changeCarTimer();
		Image4TimerMe();
		Image4();
		aaa.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent arg0) {
				if (arg0.getCode() == KeyCode.LEFT) {
					flag = true;
					if (carImage.getX() > 0.0) {
						carImage.setX(carImage.getX() - 5);
					}
				} else if (arg0.getCode() == KeyCode.RIGHT) {
					flag = false;
					if (carImage.getX() < 520) {
						carImage.setX(carImage.getX() + 5);
					}
				} else if (arg0.getCode() == KeyCode.UP) {
					if (carImage.getY() >= 30) {
						carImage.setY(carImage.getY() - 5);
					}
				} else if (arg0.getCode() == KeyCode.DOWN) {
					if (carImage.getY() < 370) {
						carImage.setY(carImage.getY() + 5);
					}
				}
			}
		});
	}

	// ��true ����Ϊ����
	public void changeCarTimer() {
		timer.schedule(new TimerTask() {
			public void run() {
				Platform.runLater(new Runnable() {
					public void run() {
						if (flag) {
							carImage.setImage(new Image(
									RunController.class
											.getResource(
													"/com/mtz/image/" + change
															+ ".png")
											.toExternalForm()));
							change = change + 1;
							if (change > 4) {
								change = 1;
							}
						} else {
							carImage.setImage(new Image(RunController.class
									.getResource(
											"/com/mtz/image/" + change2
													+ ".png").toExternalForm()));
							change2 = change2 + 1;
							if (change2 > 8) {
								change2 = 5;
							}
						}
						changeCarTimer();
					}
				});
			}
		}, 200);
	}

	// �������4��ͼ������
	public void Image4() {
		zha1.setY(50 + Math.random() * 320);
		zha1.setX(50 + Math.random() * 320);
		zha2.setY(50 + Math.random() * 320);
		zha2.setX(50 + Math.random() * 320);
		jin1.setY(50 + Math.random() * 320);
		jin1.setX(50 + Math.random() * 320);
		jin2.setY(50 + Math.random() * 320);
		jin2.setX(50 + Math.random() * 320);
	}

	public void Image4TimerMe() {
		timer.schedule(Image4Timer, 0, 100);
	}
	public void TimeTimer() {
		timer.schedule(mytimer, 0, 1000);
	}
	
}
