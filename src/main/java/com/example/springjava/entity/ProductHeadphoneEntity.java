package com.example.springjava.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "PRODUCT_HEADPHONE_DETAIL")
@Table(name = "PRODUCT_HEADPHONE_DETAIL")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductHeadphoneEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;

    // Tên sản phẩm : iPhone 14 Pro 128GB | Chính hãng VN/A-Đen
    @Column(name = "name")
    private String name;

    // Tên sản phẩm : iPhone 14 Pro 128GB | Chính hãng VN/A-Đen
    @Column(name = "title")
    private String title;

    // Nội dung : Trải ngiêm ấn tượng ...
    @Column(name = "content")
    private String content;

    //Màu
    @Column(name = "color")
    private String color;

    //headphone_type : bluetooth , jack , loa
    @Column(name = "headphone_type")
    private String headphoneType;


    //Kích thước cụ thể : dài rộng dày
    @Column(name = "dimensions")
    private String dimensions;

    //Pin
    @Column(name = "battery")
    private String battery;

    // Bluetooth
    @Column(name = "bluetooth")
    private String bluetooth;

    //Nhà phát hành
    @Column(name = "manufacturer")
    private String manufacturer;

    // khung viền
    @Column(name = "material")
    private String material;

    // công nghệ sạc: sạc nhanh , Magsafe
    @Column(name = "charging")
    private String charging;

    // cổng sạc
    @Column(name = "gate_charging")
    private String gateCharging;

    // kháng nước bụi bẩn :IP68
    @Column(name = "resistance")
    private String resistance;

    // tính năng đặc biệt : Hỗ trợ 5G, Sạc không dây, Nhận diện khuôn mặt, Kháng nước, kháng bụi
    @Column(name = "special_feature")
    private String special_feature;

    // tính năng : Hỗ trợ 5G, Sạc không dây, Nhận diện khuôn mặt, Kháng nước, kháng bụi
    @Column(name = "feature")
    private String feature;

    // Âm thanh
    @Column(name = "sound")
    private String sound;

    //microphone
    @Column(name = "microphone")
    private boolean microphone;

    // Mô tả sản phầm
    @Column(name = "description")
    private String description;

    // Điều khiển
    @Column(name = "control")
    private String control;

    // trọng lượng
    @Column(name = "weight")
    private String weight;

    @Column(name = "urlImage")
    private String urlImage;


    @OneToOne
    @JoinColumn(name = "PRODUCT_ID")
    private ProductEntity productEntity;

}
