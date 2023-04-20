-- phpMyAdmin SQL Dump
-- version 4.9.5
-- https://www.phpmyadmin.net/
--
-- Máy chủ: localhost:3306
-- Thời gian đã tạo: Th4 14, 2023 lúc 03:27 AM
-- Phiên bản máy phục vụ: 10.5.16-MariaDB
-- Phiên bản PHP: 7.3.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `id20567998_musicplay`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `album`
--

CREATE TABLE `album` (
  `IdAlbum` int(11) NOT NULL,
  `TenAlbum` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `TenCaSiAlbum` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `HinhAlbum` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `album`
--

INSERT INTO `album` (`IdAlbum`, `TenAlbum`, `TenCaSiAlbum`, `HinhAlbum`) VALUES
(1, 'Crowd', 'RPT TC, Coldzy, TDO Kwan', 'https://tienduc37.000webhostapp.com/Hinhanh/Album/crowd.jpg'),
(2, 'My Luv', 'RINI', 'https://tienduc37.000webhostapp.com/Hinhanh/Album/my%20luv.jpg'),
(3, 'Gió (Lofi)', 'Jank, 1 9 6 7', 'https://tienduc37.000webhostapp.com/Hinhanh/Album/gio.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `baihat`
--

CREATE TABLE `baihat` (
  `IdBaiHat` int(11) NOT NULL,
  `IdAlbum` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `IdTheLoai` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `IdPlaylist` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `TenBaiHat` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `HinhBaiHat` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Casi` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `LinkBaiHat` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `LuotThich` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `baihat`
--

INSERT INTO `baihat` (`IdBaiHat`, `IdAlbum`, `IdTheLoai`, `IdPlaylist`, `TenBaiHat`, `HinhBaiHat`, `Casi`, `LinkBaiHat`, `LuotThich`) VALUES
(1, '1', '0', '0', 'Crowd', 'https://tienduc37.000webhostapp.com/Hinhanh/Album/crowd.jpg', 'RPT TC, Coldzy, TDO Kwan', 'https://laitienduc37.000webhostapp.com/Crowd-RPTTCColdzyTDOKwan-8893596.mp3', 2),
(2, '0', '1', '0', 'Ưng quá chừng', 'https://tienduc37.000webhostapp.com/Hinhanh/Baihat/ungquachung.jpg', 'AMEE', 'https://laitienduc37.000webhostapp.com/UngQuaChung-AMEE-8783624_2.mp3', 1),
(3, '0', '1', '1', 'Don\'t Côi', 'https://tienduc37.000webhostapp.com/Hinhanh/Baihat/don\'tcoi.jpg', 'RPT Orijinn, Ronboogz', 'https://laitienduc37.000webhostapp.com/DontCoi-RPTOrijinnRonboogz-8345160.mp3', 1),
(4, '0', '0', '0', 'Ez Papa', 'https://tienduc37.000webhostapp.com/Hinhanh/Baihat/ezPapa1.jpg', 'Justate', 'https://laitienduc37.000webhostapp.com/EzPapa-JustaTee-9041120.mp3', 1),
(5, '0', '0', '0', 'Mến Em Rồi', 'https://tienduc37.000webhostapp.com/Hinhanh/Baihat/menemroi1.jpg', 'Hồng Thanh', 'https://laitienduc37.000webhostapp.com/MENEMROI-HongThanh-9007910.mp3', 1),
(6, '0', '0', '0', 'My full-time You', 'https://tienduc37.000webhostapp.com/Hinhanh/Baihat/myfulltimeyou1.jpg', 'Mlee', 'https://laitienduc37.000webhostapp.com/MyFulltimeYouMoc-Mlee-9007911.mp3', 1),
(7, '0', '0', '0', 'Lời Hứa Là Lời Nói Dối Hoa Mỹ / 承諾是個美麗的謊', 'https://tienduc37.000webhostapp.com/Hinhanh/Baihat/nhachoadacsac1.jpg', 'An Nhi Trần', 'https://laitienduc37.000webhostapp.com/true.mp3', 1),
(8, '0', '0', '1', 'Kìa Bóng Dáng Ai', 'https://tienduc37.000webhostapp.com/Hinhanh/Baihat/kiabongdangai.jpg', 'Pháo, Sterry', 'https://laitienduc37.000webhostapp.com/KiaBongDangAi-Phao-8544353.mp3', 1),
(9, '0', '0', '1', 'Luôn Yêu Đời', 'https://tienduc37.000webhostapp.com/Hinhanh/Baihat/Luon%20yeu%20doi.jpg', 'Đen, Cheng', 'https://laitienduc37.000webhostapp.com/LuonYeuDoi-Den-8692742_2.mp3', 1),
(10, '0', '0', '2', 'Shut Down', 'https://tienduc37.000webhostapp.com/Hinhanh/Baihat/shutdown.jpg', 'BLACKPINK', 'https://laitienduc37.000webhostapp.com/ShutDown-BLACKPINK-7887142.mp3', 1),
(11, '0', '0', '2', 'Dope', 'https://tienduc37.000webhostapp.com/Hinhanh/Baihat/dope.jpg', 'BTS', 'https://laitienduc37.000webhostapp.com/Dope-BTS-4202812.mp3', 0),
(12, '0', '0', '2', 'OMG', 'https://tienduc37.000webhostapp.com/Hinhanh/Baihat/omg.jpg', 'NewJeans', 'https://laitienduc37.000webhostapp.com/Omg-NewJeans-8497239.mp3', 0),
(13, '0', '0', '3', 'Cheri Cheri Lady (By Modern Talking)', 'https://tienduc37.000webhostapp.com/Hinhanh/Baihat/cheri%20cheri.jpg', 'Maléna', 'https://laitienduc37.000webhostapp.com/CheriCheriLadycheriCheriLadyByModernTalking-Malena-8731368.mp3', 0),
(14, '0', '0', '3', 'Flowers', 'https://tienduc37.000webhostapp.com/Hinhanh/Baihat/flower.jpg', 'Flowers - Miley Cyrus', 'https://laitienduc37.000webhostapp.com/Flowers-MileyCyrus-9035110.mp3', 0),
(15, '0', '0', '3', 'Boy\'s A Liar Pt.2', 'https://tienduc37.000webhostapp.com/Hinhanh/Baihat/boy\'s%20a%20liar.jpg', 'PinkPantheress, Ice Spice', 'https://laitienduc37.000webhostapp.com/BoySALiarPt2-PinkPantheressIceSpice-8568304.mp3', 0),
(16, '0', '1', '0', 'nếu lúc đó', 'https://tienduc37.000webhostapp.com/Hinhanh/Baihat/neulucdo.jpg', 'Tlinh, 2pillz', 'https://laitienduc37.000webhostapp.com/NeuLucDo-tlinh2pillz-8783613.mp3', 0),
(17, '0', '1', '0', 'Ghé Vào Tai', 'https://tienduc37.000webhostapp.com/Hinhanh/Baihat/ghevaotai.jpg', 'UMIE, Freaky, Hổ', 'https://laitienduc37.000webhostapp.com/GheVaoTai-UMIEFreakyHo-8514373.mp3', 0),
(18, '0', '2', '0', 'vaicaunoicokhiennguoithaydoi (acoustic)', 'https://tienduc37.000webhostapp.com/Hinhanh/Baihat/vaicaunoicokhiennguoithaydoi.jpg', 'GREY D', 'https://laitienduc37.000webhostapp.com/Vaicaunoicokhiennguoithaydoi-GREYDDoanTheLan-7576195.mp3', 0),
(19, '0', '2', '0', 'Mascara', 'https://tienduc37.000webhostapp.com/Hinhanh/Baihat/mascara.jpg', 'Chillies', 'https://laitienduc37.000webhostapp.com/Mascara-Chillies-6467676.mp3', 0),
(20, '0', '2', '0', 'Là', 'https://tienduc37.000webhostapp.com/Hinhanh/Baihat/la.jpg', 'Vũ', 'https://laitienduc37.000webhostapp.com/La-VU-6467691.mp3', 0),
(21, '2', '0', '0', 'My Luv', 'https://tienduc37.000webhostapp.com/Hinhanh/Album/my%20luv.jpg', 'RINI', 'https://laitienduc37.000webhostapp.com/MyLuv-RINI-8690619.mp3', 0),
(22, '0', '3', '0', 'Vầng Trăng Cổ Tích', 'https://tienduc37.000webhostapp.com/Hinhanh/Baihat/be%20bao%20ngu.jpg', 'Bé Bào Ngư', 'https://laitienduc37.000webhostapp.com/VangTrangCoTich-3H-BeBaoNgu_4amhn.mp3', 0),
(23, '0', '3', '0', 'Đàn Gà Trong Sân', 'https://tienduc37.000webhostapp.com/Hinhanh/Baihat/nucuoituoitho.jpg', 'Bé Thanh Thảo', 'https://laitienduc37.000webhostapp.com/DanGaTrongSan-ThanhThao_469ek.mp3', 0),
(24, '0', '3', '0', 'Chú Ếch Con', 'https://tienduc37.000webhostapp.com/Hinhanh/Baihat/chuechcon.jpg', 'Bé Nguyệt Hằng', 'https://laitienduc37.000webhostapp.com/ChuEchCon-NguyetHang_5p4.mp3', 0),
(25, '3', '1', '0', 'Gió (Lofi)', 'https://tienduc37.000webhostapp.com/Hinhanh/Album/gio.jpg', 'Jank, 1 9 6 7', 'https://laitienduc37.000webhostapp.com/GioLofi-Jank1967-8874174%20(1).mp3', 0),
(26, '0', '1', '1', 'Chìm Sâu', 'https://tienduc37.000webhostapp.com/Hinhanh/Baihat/ch%C3%ADmau.jpg', 'RPT MCK, Trung Trần', 'https://laitienduc37.000webhostapp.com/ChimSau-MCKTrungTran-7205660.mp3', 0),
(27, '0', '1', '1', 'Thôi Em Đừng Đi', 'https://tienduc37.000webhostapp.com/Hinhanh/Baihat/thoiemdungdi.jpg', 'RPT MCK, Trung Trần', 'https://laitienduc37.000webhostapp.com/ThoiEmDungDi-MCK-8804088.mp3', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chude`
--

CREATE TABLE `chude` (
  `IdChuDe` int(11) NOT NULL,
  `TenChuDe` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `HinhChuDe` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `chude`
--

INSERT INTO `chude` (`IdChuDe`, `TenChuDe`, `HinhChuDe`) VALUES
(1, 'Nhạc Việt', 'https://tienduc37.000webhostapp.com/Hinhanh/Chude/nhacviet.jpg'),
(2, 'Nhạc Thiếu Nhi\r\n', 'https://tienduc37.000webhostapp.com/Hinhanh/Chude/nhacthieunhi.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `playlist`
--

CREATE TABLE `playlist` (
  `IdPlaylist` int(11) NOT NULL,
  `Ten` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Hinhnen` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Hinhicon` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `playlist`
--

INSERT INTO `playlist` (`IdPlaylist`, `Ten`, `Hinhnen`, `Hinhicon`) VALUES
(1, 'Top 100 Rap Việt Hay Nhất ', 'https://tienduc37.000webhostapp.com/Hinhanh/Playlist/backgroundtop100rapviet.jpg', 'https://tienduc37.000webhostapp.com/Hinhanh/Playlist/top100rapviet.jpg'),
(2, 'Top 100 Nhạc Hàn Hay Nhất', 'https://tienduc37.000webhostapp.com/Hinhanh/Playlist/backgroundtop100nhachan.jpg', 'https://tienduc37.000webhostapp.com/Hinhanh/Playlist/top100nhachan.jpg'),
(3, 'Top 100 Pop USUK Hay Nhất', 'https://tienduc37.000webhostapp.com/Hinhanh/Playlist/backgroundtop100nhacpopusuk.jpg', 'https://tienduc37.000webhostapp.com/Hinhanh/Playlist/top100popusuk.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `quangcao`
--

CREATE TABLE `quangcao` (
  `Id` int(11) NOT NULL,
  `Hinhanh` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Noidung` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Idbaihat` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `quangcao`
--

INSERT INTO `quangcao` (`Id`, `Hinhanh`, `Noidung`, `Idbaihat`) VALUES
(1, 'https://tienduc37.000webhostapp.com/Hinhanh/Quangcao/ezpapa.jpg', 'Ca khúc Ez Papa do ca sĩ JustaTee thể hiện, thuộc thể loại R&B/Hip Hop/Rap', 4),
(2, 'https://tienduc37.000webhostapp.com/Hinhanh/Quangcao/menemroi.jpg', 'Ca khúc MẾN EM RỒI do ca sĩ Hồng Thanh thể hiện, thuộc thể loại Nhạc Trẻ', 5),
(3, 'https://tienduc37.000webhostapp.com/Hinhanh/Quangcao/myfulltimeyou.jpg', '\r\nCa khúc My full-time You (Mộc) do ca sĩ Mlee thể hiện, thuộc thể loại Nhạc Trẻ', 6),
(4, 'https://tienduc37.000webhostapp.com/Hinhanh/Quangcao/nhachoadacdac.jpg', 'Ca khúc Lời Hứa Là Lời Nói Dối Hoa Mỹ / 承諾是個美麗的謊 do ca sĩ An Nhi Trần thể hiện, thuộc thể loại Nhạc Hoa', 7);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `theloai`
--

CREATE TABLE `theloai` (
  `IdTheLoai` int(11) NOT NULL,
  `IdChuDe` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `TenTheLoai` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `HinhTheLoai` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `theloai`
--

INSERT INTO `theloai` (`IdTheLoai`, `IdChuDe`, `TenTheLoai`, `HinhTheLoai`) VALUES
(1, '1', 'Hit Việt Quốc Dân', 'https://tienduc37.000webhostapp.com/Hinhanh/Theloai/hitvietquocdan.jpg'),
(2, '1', 'Acoustic Việt', 'https://tienduc37.000webhostapp.com/Hinhanh/Theloai/aucosticviet.jpg'),
(3, '2', 'For Kids', 'https://tienduc37.000webhostapp.com/Hinhanh/Theloai/forkid.jpg');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `album`
--
ALTER TABLE `album`
  ADD PRIMARY KEY (`IdAlbum`);

--
-- Chỉ mục cho bảng `baihat`
--
ALTER TABLE `baihat`
  ADD PRIMARY KEY (`IdBaiHat`);

--
-- Chỉ mục cho bảng `chude`
--
ALTER TABLE `chude`
  ADD PRIMARY KEY (`IdChuDe`);

--
-- Chỉ mục cho bảng `playlist`
--
ALTER TABLE `playlist`
  ADD PRIMARY KEY (`IdPlaylist`);

--
-- Chỉ mục cho bảng `quangcao`
--
ALTER TABLE `quangcao`
  ADD PRIMARY KEY (`Id`);

--
-- Chỉ mục cho bảng `theloai`
--
ALTER TABLE `theloai`
  ADD PRIMARY KEY (`IdTheLoai`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `album`
--
ALTER TABLE `album`
  MODIFY `IdAlbum` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `baihat`
--
ALTER TABLE `baihat`
  MODIFY `IdBaiHat` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT cho bảng `chude`
--
ALTER TABLE `chude`
  MODIFY `IdChuDe` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `playlist`
--
ALTER TABLE `playlist`
  MODIFY `IdPlaylist` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `quangcao`
--
ALTER TABLE `quangcao`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `theloai`
--
ALTER TABLE `theloai`
  MODIFY `IdTheLoai` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
