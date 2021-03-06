USE [BookManagement]
GO
/****** Object:  Table [dbo].[Book]    Script Date: 12/18/2021 10:32:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Book](
	[BookID] [int] IDENTITY(1,1) NOT NULL,
	[BookTitle] [varchar](max) NULL,
	[Author] [varchar](max) NULL,
	[Brief] [varchar](max) NULL,
	[Publisher] [varchar](max) NULL,
	[Image] [varchar](max) NULL,
	[Content] [varchar](max) NULL,
	[Category] [varchar](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[BookID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[BookCase]    Script Date: 12/18/2021 10:32:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BookCase](
	[BookCaseID] [int] NOT NULL,
	[BookCaseName] [varchar](max) NOT NULL,
 CONSTRAINT [PK__BookCase__9EF3CE66FDA7346F] PRIMARY KEY CLUSTERED 
(
	[BookCaseID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Contain]    Script Date: 12/18/2021 10:32:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Contain](
	[BookCaseID] [int] NOT NULL,
	[BookID] [int] NULL,
	[CreateDate] [date] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[userInfor]    Script Date: 12/18/2021 10:32:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[userInfor](
	[userID] [int] NOT NULL,
	[userName] [varchar](max) NULL,
	[password] [varchar](max) NULL,
	[roleID] [bit] NULL,
	[BookCaseID] [int] NULL,
 CONSTRAINT [PK__userInfo__CB9A1CDF19FAFBFC] PRIMARY KEY CLUSTERED 
(
	[userID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[userRole]    Script Date: 12/18/2021 10:32:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[userRole](
	[roleID] [bit] NOT NULL,
	[authority] [varchar](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[roleID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Book] ON 

INSERT [dbo].[Book] ([BookID], [BookTitle], [Author], [Brief], [Publisher], [Image], [Content], [Category]) VALUES (1, N'One Hundred Years', N'Lilia', N'How can i solve it', N'29/11/200', N'7.jpg', N'hahahahaah', N'Drama')
INSERT [dbo].[Book] ([BookID], [BookTitle], [Author], [Brief], [Publisher], [Image], [Content], [Category]) VALUES (2, N'One Hundred Years', N'Lilia', N'How can i solve it', N'29/11/200', N'8.jpg', N'hahahahaah', N'Drama')
INSERT [dbo].[Book] ([BookID], [BookTitle], [Author], [Brief], [Publisher], [Image], [Content], [Category]) VALUES (3, N'One Hundred Years', N'Lilia', N'How can i solve it', N'29/11/200', N'7.jpg', N'hahahahaah', N'Drama')
INSERT [dbo].[Book] ([BookID], [BookTitle], [Author], [Brief], [Publisher], [Image], [Content], [Category]) VALUES (4, N'One Hundred Years', N'Lilia', N'How can i solve it', N'29/11/200', N'8.jpg', N'hahahahaah', N'Drama')
INSERT [dbo].[Book] ([BookID], [BookTitle], [Author], [Brief], [Publisher], [Image], [Content], [Category]) VALUES (5, N'One Hundred Years', N'Lilia', N'How can i solve it', N'29/11/200', N'7.jpg', N'hahahahaah', N'Drama')
INSERT [dbo].[Book] ([BookID], [BookTitle], [Author], [Brief], [Publisher], [Image], [Content], [Category]) VALUES (6, N'One Hundred Years', N'Lilia', N'How can i solve it', N'29/11/200', N'8.jpg', N'hahahahaah', N'Drama')
INSERT [dbo].[Book] ([BookID], [BookTitle], [Author], [Brief], [Publisher], [Image], [Content], [Category]) VALUES (7, N'One Hundred Years', N'Lilia', N'How can i solve it', N'29/11/200', N'7.jpg', N'hahahahaah', N'Drama')
INSERT [dbo].[Book] ([BookID], [BookTitle], [Author], [Brief], [Publisher], [Image], [Content], [Category]) VALUES (8, N'One Hundred Years', N'Lilia', N'How can i solve it', N'29/11/200', N'8.jpg', N'hahahahaah', N'Drama')
INSERT [dbo].[Book] ([BookID], [BookTitle], [Author], [Brief], [Publisher], [Image], [Content], [Category]) VALUES (9, N'One Hundred Years', N'Lilia', N'How can i solve it', N'29/11/200', N'7.jpg', N'hahahahaah', N'Drama')
INSERT [dbo].[Book] ([BookID], [BookTitle], [Author], [Brief], [Publisher], [Image], [Content], [Category]) VALUES (10, N'One Hundred Years', N'Lilia', N'How can i solve it', N'29/11/200', N'8.jpg', N'hahahahaah', N'Drama')
INSERT [dbo].[Book] ([BookID], [BookTitle], [Author], [Brief], [Publisher], [Image], [Content], [Category]) VALUES (11, N'One Hundred Years', N'Lilia', N'How can i solve it', N'29/11/200', N'7.jpg', N'hahahahaah', N'Drama')
INSERT [dbo].[Book] ([BookID], [BookTitle], [Author], [Brief], [Publisher], [Image], [Content], [Category]) VALUES (12, N'One Hundred Years', N'Lilia', N'How can i solve it', N'29/11/200', N'8.jpg', N'hahahahaah', N'Drama')
INSERT [dbo].[Book] ([BookID], [BookTitle], [Author], [Brief], [Publisher], [Image], [Content], [Category]) VALUES (13, N'One Hundred Years', N'Lilia', N'How can i solve it', N'29/11/200', N'7.jpg', N'hahahahaah', N'Drama')
INSERT [dbo].[Book] ([BookID], [BookTitle], [Author], [Brief], [Publisher], [Image], [Content], [Category]) VALUES (14, N'One Hundred Years', N'Lilia', N'How can i solve it', N'29/11/200', N'8.jpg', N'hahahahaah', N'Drama')
INSERT [dbo].[Book] ([BookID], [BookTitle], [Author], [Brief], [Publisher], [Image], [Content], [Category]) VALUES (15, N'One Hundred Years', N'Lilia', N'How can i solve it', N'29/11/200', N'7.jpg', N'hahahahaah', N'Drama')
INSERT [dbo].[Book] ([BookID], [BookTitle], [Author], [Brief], [Publisher], [Image], [Content], [Category]) VALUES (16, N'One Hundred Years', N'Lilia', N'How can i solve it', N'29/11/200', N'8.jpg', N'hahahahaah', N'Drama')
INSERT [dbo].[Book] ([BookID], [BookTitle], [Author], [Brief], [Publisher], [Image], [Content], [Category]) VALUES (17, N'One Hundred Years', N'Lilia', N'How can i solve it', N'29/11/200', N'7.jpg', N'hahahahaah', N'Drama')
INSERT [dbo].[Book] ([BookID], [BookTitle], [Author], [Brief], [Publisher], [Image], [Content], [Category]) VALUES (18, N'One Hundred Years', N'Lilia', N'How can i solve it', N'29/11/200', N'8.jpg', N'hahahahaah', N'Drama')
INSERT [dbo].[Book] ([BookID], [BookTitle], [Author], [Brief], [Publisher], [Image], [Content], [Category]) VALUES (19, N'One Hundred Years', N'Lilia', N'How can i solve it', N'29/11/200', N'7.jpg', N'hahahahaah', N'Drama')
INSERT [dbo].[Book] ([BookID], [BookTitle], [Author], [Brief], [Publisher], [Image], [Content], [Category]) VALUES (20, N'One Hundred Years', N'Lilia', N'How can i solve it', N'29/11/200', N'8.jpg', N'hahahahaah', N'Drama')
INSERT [dbo].[Book] ([BookID], [BookTitle], [Author], [Brief], [Publisher], [Image], [Content], [Category]) VALUES (21, N'One Hundred Years', N'Lilia', N'How can i solve it', N'29/11/200', N'7.jpg', N'hahahahaah', N'Drama')
INSERT [dbo].[Book] ([BookID], [BookTitle], [Author], [Brief], [Publisher], [Image], [Content], [Category]) VALUES (22, N'One Hundred Years', N'Lilia', N'How can i solve it', N'29/11/200', N'8.jpg', N'hahahahaah', N'Drama')
INSERT [dbo].[Book] ([BookID], [BookTitle], [Author], [Brief], [Publisher], [Image], [Content], [Category]) VALUES (23, N'One Hundred Years', N'Lilia', N'How can i solve it', N'29/11/200', N'7.jpg', N'hahahahaah', N'Drama')
INSERT [dbo].[Book] ([BookID], [BookTitle], [Author], [Brief], [Publisher], [Image], [Content], [Category]) VALUES (24, N'One Hundred Years', N'Lilia', N'How can i solve it', N'29/11/200', N'8.jpg', N'hahahahaah', N'Drama')
INSERT [dbo].[Book] ([BookID], [BookTitle], [Author], [Brief], [Publisher], [Image], [Content], [Category]) VALUES (25, N'One Hundred Years', N'Lilia', N'How can i solve it', N'29/11/200', N'7.jpg', N'hahahahaah', N'Drama')
INSERT [dbo].[Book] ([BookID], [BookTitle], [Author], [Brief], [Publisher], [Image], [Content], [Category]) VALUES (26, N'One Hundred Years', N'Lilia', N'How can i solve it', N'29/11/200', N'8.jpg', N'hahahahaah', N'Drama')
INSERT [dbo].[Book] ([BookID], [BookTitle], [Author], [Brief], [Publisher], [Image], [Content], [Category]) VALUES (27, N'One Hundred Years', N'Lilia', N'How can i solve it', N'29/11/200', N'7.jpg', N'hahahahaah', N'Drama')
INSERT [dbo].[Book] ([BookID], [BookTitle], [Author], [Brief], [Publisher], [Image], [Content], [Category]) VALUES (28, N'One Hundred Years', N'Lilia', N'How can i solve it', N'29/11/200', N'8.jpg', N'hahahahaah', N'Drama')
INSERT [dbo].[Book] ([BookID], [BookTitle], [Author], [Brief], [Publisher], [Image], [Content], [Category]) VALUES (29, N'One Hundred Years', N'Lilia', N'How can i solve it', N'29/11/200', N'7.jpg', N'hahahahaah', N'Drama')
INSERT [dbo].[Book] ([BookID], [BookTitle], [Author], [Brief], [Publisher], [Image], [Content], [Category]) VALUES (30, N'One Hundred Years', N'Lilia', N'How can i solve it', N'29/11/200', N'7.jpg', N'hahahahaah', N'Drama')
INSERT [dbo].[Book] ([BookID], [BookTitle], [Author], [Brief], [Publisher], [Image], [Content], [Category]) VALUES (31, N'One Hundred Years', N'Lilia', N'How can i solve it', N'29/11/200', N'7.jpg', N'hahahahaah', N'Drama')
INSERT [dbo].[Book] ([BookID], [BookTitle], [Author], [Brief], [Publisher], [Image], [Content], [Category]) VALUES (32, N'One Hundred Years', N'Lilia', N'How can i solve it', N'29/11/200', N'7.jpg', N'hahahahaah', N'Drama')
INSERT [dbo].[Book] ([BookID], [BookTitle], [Author], [Brief], [Publisher], [Image], [Content], [Category]) VALUES (33, N'One Hundred Years', N'Lilia', N'How can i solve it', N'29/11/200', N'7.jpg', N'hahahahaah', N'Drama')
INSERT [dbo].[Book] ([BookID], [BookTitle], [Author], [Brief], [Publisher], [Image], [Content], [Category]) VALUES (34, N'One Hundred Years', N'Lilia', N'How can i solve it', N'29/11/200', N'7.jpg', N'hahahahaah', N'Drama')
INSERT [dbo].[Book] ([BookID], [BookTitle], [Author], [Brief], [Publisher], [Image], [Content], [Category]) VALUES (35, N'One Hundred Years', N'Lilia', N'How can i solve it', N'29/11/200', N'7.jpg', N'hahahahaah', N'Drama')
INSERT [dbo].[Book] ([BookID], [BookTitle], [Author], [Brief], [Publisher], [Image], [Content], [Category]) VALUES (36, N'One Hundred Years', N'Lilia', N'How can i solve it', N'29/11/200', N'7.jpg', N'hahahahaah', N'Drama')
INSERT [dbo].[Book] ([BookID], [BookTitle], [Author], [Brief], [Publisher], [Image], [Content], [Category]) VALUES (37, N'One Hundred Years', N'Lilia', N'How can i solve it', N'29/11/200', N'7.jpg', N'hahahahaah', N'Drama')
INSERT [dbo].[Book] ([BookID], [BookTitle], [Author], [Brief], [Publisher], [Image], [Content], [Category]) VALUES (38, N'One Hundred Years', N'Lilia', N'How can i solve it', N'29/11/200', N'7.jpg', N'hahahahaah', N'Drama')
INSERT [dbo].[Book] ([BookID], [BookTitle], [Author], [Brief], [Publisher], [Image], [Content], [Category]) VALUES (39, N'One Hundred Years', N'Lilia', N'How can i solve it', N'29/11/200', N'7.jpg', N'hahahahaah', N'Drama')
INSERT [dbo].[Book] ([BookID], [BookTitle], [Author], [Brief], [Publisher], [Image], [Content], [Category]) VALUES (40, N'One Hundred Years', N'Lilia', N'How can i solve it', N'29/11/200', N'7.jpg', N'hahahahaah', N'Drama')
INSERT [dbo].[Book] ([BookID], [BookTitle], [Author], [Brief], [Publisher], [Image], [Content], [Category]) VALUES (41, N'One Hundred Years', N'Lilia', N'How can i solve it', N'29/11/200', N'7.jpg', N'hahahahaah', N'Drama')
INSERT [dbo].[Book] ([BookID], [BookTitle], [Author], [Brief], [Publisher], [Image], [Content], [Category]) VALUES (42, N'One Hundred Years', N'Lilia', N'How can i solve it', N'29/11/200', N'7.jpg', N'hahahahaah', N'Drama')
INSERT [dbo].[Book] ([BookID], [BookTitle], [Author], [Brief], [Publisher], [Image], [Content], [Category]) VALUES (43, N'One Hundred Years', N'Lilia', N'How can i solve it', N'29/11/200', N'7.jpg', N'hahahahaah', N'Drama')
INSERT [dbo].[Book] ([BookID], [BookTitle], [Author], [Brief], [Publisher], [Image], [Content], [Category]) VALUES (44, N'One Hundred Years', N'Lilia', N'How can i solve it', N'29/11/200', N'7.jpg', N'hahahahaah', N'Drama')
INSERT [dbo].[Book] ([BookID], [BookTitle], [Author], [Brief], [Publisher], [Image], [Content], [Category]) VALUES (45, N'One Hundred Years', N'Lilia', N'How can i solve it', N'29/11/200', N'7.jpg', N'hahahahaah', N'Drama')
INSERT [dbo].[Book] ([BookID], [BookTitle], [Author], [Brief], [Publisher], [Image], [Content], [Category]) VALUES (46, N'One Hundred Years', N'Lilia', N'How can i solve it', N'29/11/200', N'7.jpg', N'hahahahaah', N'Drama')
INSERT [dbo].[Book] ([BookID], [BookTitle], [Author], [Brief], [Publisher], [Image], [Content], [Category]) VALUES (47, N'One Hundred Years', N'Lilia', N'How can i solve it', N'29/11/200', N'7.jpg', N'hahahahaah', N'Drama')
INSERT [dbo].[Book] ([BookID], [BookTitle], [Author], [Brief], [Publisher], [Image], [Content], [Category]) VALUES (48, N'One Hundred Years', N'Lilia', N'How can i solve it', N'29/11/200', N'7.jpg', N'hahahahaah', N'Drama')
INSERT [dbo].[Book] ([BookID], [BookTitle], [Author], [Brief], [Publisher], [Image], [Content], [Category]) VALUES (49, N'One Hundred Years', N'Lilia', N'How can i solve it', N'29/11/200', N'7.jpg', N'hahahahaah', N'Drama')
INSERT [dbo].[Book] ([BookID], [BookTitle], [Author], [Brief], [Publisher], [Image], [Content], [Category]) VALUES (50, N'One Hundred Years', N'Lilia', N'How can i solve it', N'29/11/200', N'7.jpg', N'hahahahaah', N'Drama')
INSERT [dbo].[Book] ([BookID], [BookTitle], [Author], [Brief], [Publisher], [Image], [Content], [Category]) VALUES (51, N'One Hundred Years', N'Lilia', N'How can i solve it', N'29/11/200', N'7.jpg', N'hahahahaah', N'Drama')
INSERT [dbo].[Book] ([BookID], [BookTitle], [Author], [Brief], [Publisher], [Image], [Content], [Category]) VALUES (52, N'One Hundred Years', N'Lilia', N'How can i solve it', N'29/11/200', N'7.jpg', N'hahahahaah', N'Drama')
INSERT [dbo].[Book] ([BookID], [BookTitle], [Author], [Brief], [Publisher], [Image], [Content], [Category]) VALUES (53, N'One Hundred Years', N'Lilia', N'How can i solve it', N'29/11/200', N'7.jpg', N'hahahahaah', N'Drama')
INSERT [dbo].[Book] ([BookID], [BookTitle], [Author], [Brief], [Publisher], [Image], [Content], [Category]) VALUES (54, N'One Hundred Years', N'Lilia', N'How can i solve it', N'29/11/200', N'7.jpg', N'hahahahaah', N'Drama')
INSERT [dbo].[Book] ([BookID], [BookTitle], [Author], [Brief], [Publisher], [Image], [Content], [Category]) VALUES (55, N'One Hundred Years', N'Lilia', N'How can i solve it', N'29/11/200', N'7.jpg', N'hahahahaah', N'Drama')
INSERT [dbo].[Book] ([BookID], [BookTitle], [Author], [Brief], [Publisher], [Image], [Content], [Category]) VALUES (56, N'One Hundred Years', N'Lilia', N'How can i solve it', N'29/11/200', N'7.jpg', N'hahahahaah', N'Drama')
INSERT [dbo].[Book] ([BookID], [BookTitle], [Author], [Brief], [Publisher], [Image], [Content], [Category]) VALUES (57, N'One Hundred Years', N'Lilia', N'How can i solve it', N'29/11/200', N'7.jpg', N'hahahahaah', N'Drama')
INSERT [dbo].[Book] ([BookID], [BookTitle], [Author], [Brief], [Publisher], [Image], [Content], [Category]) VALUES (58, N'One Hundred Years', N'Lilia', N'How can i solve it', N'29/11/200', N'7.jpg', N'hahahahaah', N'Drama')
INSERT [dbo].[Book] ([BookID], [BookTitle], [Author], [Brief], [Publisher], [Image], [Content], [Category]) VALUES (59, N'One Hundred Years', N'Lilia', N'How can i solve it', N'29/11/200', N'7.jpg', N'hahahahaah', N'Drama')
INSERT [dbo].[Book] ([BookID], [BookTitle], [Author], [Brief], [Publisher], [Image], [Content], [Category]) VALUES (60, N'One Hundred Years', N'Lilia', N'How can i solve it', N'29/11/200', N'7.jpg', N'hahahahaah', N'Drama')
INSERT [dbo].[Book] ([BookID], [BookTitle], [Author], [Brief], [Publisher], [Image], [Content], [Category]) VALUES (61, N'One Hundred Years', N'Lilia', N'How can i solve it', N'29/11/200', N'7.jpg', N'hahahahaah', N'Drama')
INSERT [dbo].[Book] ([BookID], [BookTitle], [Author], [Brief], [Publisher], [Image], [Content], [Category]) VALUES (62, N'One Hundred Years', N'Lilia', N'How can i solve it', N'29/11/200', N'7.jpg', N'hahahahaah', N'Drama')
INSERT [dbo].[Book] ([BookID], [BookTitle], [Author], [Brief], [Publisher], [Image], [Content], [Category]) VALUES (63, N'One Hundred Years', N'Lilia', N'How can i solve it', N'29/11/200', N'7.jpg', N'hahahahaah', N'Drama')
INSERT [dbo].[Book] ([BookID], [BookTitle], [Author], [Brief], [Publisher], [Image], [Content], [Category]) VALUES (64, N'One Hundred Years', N'Lilia', N'How can i solve it', N'29/11/200', N'7.jpg', N'hahahahaah', N'Drama')
INSERT [dbo].[Book] ([BookID], [BookTitle], [Author], [Brief], [Publisher], [Image], [Content], [Category]) VALUES (65, N'One Hundred Years', N'Lilia', N'How can i solve it', N'29/11/200', N'7.jpg', N'hahahahaah', N'Drama')
INSERT [dbo].[Book] ([BookID], [BookTitle], [Author], [Brief], [Publisher], [Image], [Content], [Category]) VALUES (66, N'One Hundred Years', N'Lilia', N'How can i solve it', N'29/11/200', N'7.jpg', N'hahahahaah', N'Drama')
INSERT [dbo].[Book] ([BookID], [BookTitle], [Author], [Brief], [Publisher], [Image], [Content], [Category]) VALUES (67, N'One Hundred Years', N'Lilia', N'How can i solve it', N'29/11/200', N'7.jpg', N'hahahahaah', N'Drama')
INSERT [dbo].[Book] ([BookID], [BookTitle], [Author], [Brief], [Publisher], [Image], [Content], [Category]) VALUES (68, N'One Hundred Years', N'Lilia', N'How can i solve it', N'29/11/200', N'7.jpg', N'hahahahaah', N'Drama')
INSERT [dbo].[Book] ([BookID], [BookTitle], [Author], [Brief], [Publisher], [Image], [Content], [Category]) VALUES (69, N'One Hundred Years', N'Lilia', N'How can i solve it', N'29/11/200', N'7.jpg', N'hahahahaah', N'Drama')
INSERT [dbo].[Book] ([BookID], [BookTitle], [Author], [Brief], [Publisher], [Image], [Content], [Category]) VALUES (70, N'One Hundred Years', N'Lilia', N'How can i solve it', N'29/11/200', N'7.jpg', N'hahahahaah', N'Drama')
INSERT [dbo].[Book] ([BookID], [BookTitle], [Author], [Brief], [Publisher], [Image], [Content], [Category]) VALUES (71, N'One Hundred Years', N'Lilia', N'How can i solve it', N'29/11/200', N'7.jpg', N'hahahahaah', N'Drama')
SET IDENTITY_INSERT [dbo].[Book] OFF
INSERT [dbo].[BookCase] ([BookCaseID], [BookCaseName]) VALUES (1, N'Yeu thich')
INSERT [dbo].[BookCase] ([BookCaseID], [BookCaseName]) VALUES (2, N'Hay')
INSERT [dbo].[BookCase] ([BookCaseID], [BookCaseName]) VALUES (3, N'Ko hay')
INSERT [dbo].[BookCase] ([BookCaseID], [BookCaseName]) VALUES (4, N'Kinh di')
INSERT [dbo].[BookCase] ([BookCaseID], [BookCaseName]) VALUES (5, N'Romance')
INSERT [dbo].[Contain] ([BookCaseID], [BookID], [CreateDate]) VALUES (1, NULL, NULL)
INSERT [dbo].[Contain] ([BookCaseID], [BookID], [CreateDate]) VALUES (1, NULL, NULL)
INSERT [dbo].[Contain] ([BookCaseID], [BookID], [CreateDate]) VALUES (2, NULL, NULL)
INSERT [dbo].[Contain] ([BookCaseID], [BookID], [CreateDate]) VALUES (2, NULL, NULL)
INSERT [dbo].[Contain] ([BookCaseID], [BookID], [CreateDate]) VALUES (3, 5, NULL)
INSERT [dbo].[Contain] ([BookCaseID], [BookID], [CreateDate]) VALUES (3, 6, NULL)
INSERT [dbo].[userInfor] ([userID], [userName], [password], [roleID], [BookCaseID]) VALUES (2, N'Quang123', N'123456789', 0, 1)
INSERT [dbo].[userInfor] ([userID], [userName], [password], [roleID], [BookCaseID]) VALUES (3, N'Tuan123', N'123', 1, 2)
INSERT [dbo].[userInfor] ([userID], [userName], [password], [roleID], [BookCaseID]) VALUES (4, N'Long123', N'123', 1, 3)
INSERT [dbo].[userInfor] ([userID], [userName], [password], [roleID], [BookCaseID]) VALUES (5, N'Minh123', N'123', 1, 4)
INSERT [dbo].[userInfor] ([userID], [userName], [password], [roleID], [BookCaseID]) VALUES (6, N'Dat123', N'123', 1, 5)
INSERT [dbo].[userRole] ([roleID], [authority]) VALUES (0, N'admin')
INSERT [dbo].[userRole] ([roleID], [authority]) VALUES (1, N'user')
ALTER TABLE [dbo].[Contain]  WITH CHECK ADD  CONSTRAINT [FK_Contain_Book] FOREIGN KEY([BookID])
REFERENCES [dbo].[Book] ([BookID])
GO
ALTER TABLE [dbo].[Contain] CHECK CONSTRAINT [FK_Contain_Book]
GO
ALTER TABLE [dbo].[Contain]  WITH CHECK ADD  CONSTRAINT [FK_Contain_BookCase] FOREIGN KEY([BookCaseID])
REFERENCES [dbo].[BookCase] ([BookCaseID])
GO
ALTER TABLE [dbo].[Contain] CHECK CONSTRAINT [FK_Contain_BookCase]
GO
ALTER TABLE [dbo].[userInfor]  WITH CHECK ADD  CONSTRAINT [FK_userInfor_BookCase] FOREIGN KEY([BookCaseID])
REFERENCES [dbo].[BookCase] ([BookCaseID])
GO
ALTER TABLE [dbo].[userInfor] CHECK CONSTRAINT [FK_userInfor_BookCase]
GO
ALTER TABLE [dbo].[userInfor]  WITH CHECK ADD  CONSTRAINT [FK_userInfor_userRole] FOREIGN KEY([roleID])
REFERENCES [dbo].[userRole] ([roleID])
GO
ALTER TABLE [dbo].[userInfor] CHECK CONSTRAINT [FK_userInfor_userRole]
GO
