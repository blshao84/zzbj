import os
import zipfile


def zip(source_files, targer):
    zp = zipfile.ZipFile(targer, 'w', zipfile.ZIP_DEFLATED)
    for file in source_files:
        zp.write(file)
    zp.close()
    print('zip压缩完成')


def zipDir(dirpath, outFullName):
    """
    压缩指定文件夹
    :param dirpath: 目标文件夹路径
    :param outFullName: 压缩文件保存路径+xxxx.zip
    :return: 无
    """
    zip = zipfile.ZipFile(outFullName, "w", zipfile.ZIP_DEFLATED)
    for path, dirnames, filenames in os.walk(dirpath):
        # 去掉目标跟路径，只对目标文件夹下边的文件及文件夹进行压缩
        fpath = path.replace(dirpath, '')
        for filename in filenames:
            zip.write(os.path.join(path, filename), os.path.join(fpath, filename))
    zip.close()
    print('zip压缩完成')



if __name__ == '__main__':
    # zip(['D://testdir//SFMS_OPTION_20201122.csv', 'D://testdir//SFMS_OPTION_20201122_180436.csv'], './tes.zip')
    zipDir('D://testdir', 'D://Backup//桌面//test.zip')
    pass
