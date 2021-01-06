import os

def create_folder(folder_name):
    result_data = 0
    folder_name_exist = os.path.exists(folder_name)
    if not folder_name_exist:
        os.makedirs(folder_name)
    if not os.path.exists(folder_name):
        result_data = 1
    return result_data

def delete_folder(path):
    for i in os.listdir(path):
        path_file = os.path.join(path, i)
        if os.path.isfile(path_file):
            os.remove(path_file)
        else:
            delete_folder(path_file)
    os.removedirs(path)

if __name__ == '__main__':
    create_folder('tmp')
    print('aaaa')
    delete_folder('tmp')