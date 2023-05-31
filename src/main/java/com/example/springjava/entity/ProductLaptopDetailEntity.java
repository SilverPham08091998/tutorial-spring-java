package com.example.springjava.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity(name = "PRODUCT_LAPTOP_DETAIL")
@Table(name = "PRODUCT_LAPTOP_DETAIL")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductLaptopDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;
    // tên sản phầm : Macbook  Pro 14inch
    @Column(name = "name")
    private String name;
    // tên sản phầm : Macbook  Pro 14inch
    @Column(name = "title")
    private String title;
    // Nội dung
    @Column(name = "content")
    private String content;
    // màu
    @Column(name = "color")
    private String color;
    // CPU : apple M1
    @Column(name = "cpu")
    private String cpu;
    // ssd : 512
    @Column(name = "ssd")
    private String ssd;
    // ram 8gb
    @Column(name = "ram")
    private String ram;

    // độ phân giải : 5120x1280 pixel
    @Column(name = "display_resolution")
    private String displayResolution;

    // kích thước : 14 inch
    @Column(name = "display_size")
    private String displaySize;

    //kiểu hiển thị : liquid retina
    @Column(name = "display_type")
    private String displayType;

    // tần số quét
    @Column(name = "frequency")
    private String frequency;

    //vga: 8 nhân GPU, 16 nhân Neural Engine
    @Column(name = "vga")
    private String vga;
    //Kích thước : dài rộng dày;
    @Column(name = "dimensions")
    private String dimensions;
    // Pin
    @Column(name = "battery")
    private String battery;
    // bluetooth
    @Column(name = "bluetooth")
    private String bluetooth;
    // Nhà phát hành
    @Column(name = "manufacturer")
    private String manufacturer;
    // camera :
    @Column(name = "camera_webcam")
    private String cameraWebcam;
    // vân tay
    @Column(name = "fingerprint")
    private boolean fingerprint;
    // mở khóa nhận dạng khuôn mặt
    @Column(name = "faceId")
    private boolean faceId;
    // khung : kim loại
    @Column(name = "material")
    private String material;
    // tầm nền màn hình : IPS
    @Column(name = "panels")
    private String panels;
    // âm thanh 3 microphones, 4 Loa
    @Column(name = "sound")
    private String sound;
    // card đồ họa : GTX
    @Column(name = "card")
    private String card;
    // Mô tả sản phẩm
    @Column(name = "description")
    private String description;
    // hệ điều hành
    @Column(name = "operation_system")
    private String operationSystem;
    // số lượng port
    @Column(name = "port")
    private String port;
    // trọng lượng
    @Column(name = "weight")
    private String weight;
    // kết nối internet
    @Column(name = "wifiLan")
    private String wifiLan;

    // công nghệ sạc
    @Column(name = "charging")
    private String charging;
    // cổng sạc
    @Column(name = "gate_charging")
    private String gateCharging;

    @OneToOne
    @JoinColumn(name = "PRODUCT_ID")
    private ProductEntity productEntity;
}
