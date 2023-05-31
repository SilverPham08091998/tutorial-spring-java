package com.example.springjava.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "PRODUCT_PHONE_DETAIL")
@Table(name = "PRODUCT_PHONE_DETAIL")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductPhoneDetailEntity {
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

    // CPU: 6 nhân
    @Column(name = "cpu")
    private String cpu;

    // RAM : 8GB
    @Column(name = "ram")
    private String ram;

    // Số lượng thẻ nhớ
    @Column(name = "memory_card_slot")
    private String memoryCardSlot;

    //Độ phân giải : 2556 x 1179 pixels
    @Column(name = "display_resolution")
    private String displayResolution;

    //Kích thước : 6.1 inch
    @Column(name = "display_size")
    private String displaySize;

    //Loại màn hình:  OLED
    @Column(name = "display_type")
    private String displayType;

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

    // Camera chính :Camera chính: 48MP <br>Camera góc siêu rộng: 12MP<br> Camera tele: 12MP
    @Column(name = "camera_primary")
    private String cameraPrimary;

    //Camera phụ 12MP
    @Column(name = "camera_secondary")
    private String cameraSecondary;

    //Chức năng camera Chụp macro, Chụp xóa phông, Chụp góc rộng, Quay video 4K, Chống rung, Chụp Zoom xa
    @Column(name = "camera_feature")
    private String cameraFeature;

    // Chức năng quay video 4K @24 fps, 25 fps, 30 fps, 60 fps<br>1080p @25 fps, 30 fps, 60 fps<br>720p @30 fps<br>4K HDR @30 fps<br>2.8K @ 60 fps<br>HDR với Dolby Vision @60 fps<br>ProRes 4K @ 30fps<br>Chuyển động chậm 1080p @ 120fps, 240 fps
    @Column(name = "video_feature")
    private String videoFeature;

    //Độ phân giải quay video
    @Column(name = "camera_video")
    private String cameraVideo;

    // Chip
    @Column(name = "chip_set")
    private String chipSet;

    //GPS
    @Column(name = "gps")
    private String gps;

    //GPU
    @Column(name = "gpu")
    private String gpu;

    //Vân tay
    @Column(name = "fingerprint")
    private boolean fingerprint;

    // Nhân diện khuôn mặt
    @Column(name = "faceId")
    private boolean faceId;

    // khung viền
    @Column(name = "material")
    private String material;

    // mặt lưng
    @Column(name = "behind_material")
    private String behindMaterial;

    // cảm biến
    @Column(name = "sensor")
    private String sensor;

    // tần số quét
    @Column(name = "frequency")
    private String frequency;

    // công nghệ sạc: sạc nhanh , Magsafe
    @Column(name = "charging")
    private String charging;

    // cổng sạc
    @Column(name = "gate_charging")
    private String gateCharging;
    // kiểu màn hình: tai thỏ , đục lỗ
    @Column(name = "type_screen")
    private String typeScreen;
    //Cộng nghệ hiển thị: Công nghệ ProMotion với tần số quét 120Hz<br>Tỷ lệ tương phản 2.000.000: 1<br>Độ sáng tối đa: 1.000 nits (điển hình), 1.600 nits (HDR), 2.000 nits (ngoài trời)
    @Column(name = "display")
    private String display;

    // kháng nước bụi bẩn :IP68
    @Column(name = "resistance")
    private String resistance;

    // tính năng đặc biệt : Hỗ trợ 5G, Sạc không dây, Nhận diện khuôn mặt, Kháng nước, kháng bụi
    @Column(name = "special_feature")
    private String special_feature;
    // Âm thanh
    @Column(name = "sound")
    private String sound;
    // Mô tả sản phầm
    @Column(name = "description")
    private String description;
    // hệ diều hành
    @Column(name = "operation_system")
    private String operationSystem;

    // độ sáng 300 cd/m2
    @Column(name = "brightness")
    private String brightness;

    // trọng lượng
    @Column(name = "weight")
    private String weight;

    @Column(name = "urlImage")
    private String urlImage;

    @OneToOne
    @JoinColumn(name = "PRODUCT_ID")
    private ProductEntity productEntity;

}
