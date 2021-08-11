import random

print("Welcome!")

print(" ")

time = 0
p_move = 0
choice = 0
c_move = 0


while choice == 0:
    user_A = int(input("Enter the WIDTH of the grid between 2 and 50: "))
    if 2<=user_A<=50:
        print("The width of the grid that you picked was: " + str(user_A)) #Get rid of this at the end
        choice += 1
        print(" ")
    else:
        print("Error, number not in bounds! Try again!")
        print(" ")

choice = 0

while choice == 0:
    user_B = int(input("Enter the HEIGHT of the grid between 2 and 50: "))
    if 2<=user_B<=50:
        print("The height of the grid that you picked was: " + str(user_B)) #Get rid of this at the end, for testing purposes
        choice += 1
        print(" ")
    else:
        print("Error, number not in bounds! Try again!")
        print(" ")

width, height = (user_A, user_B)
forest = [[0 for i in range(height)] for j in range(width)]
#for width in forest:
#    print(width)

patl = 0
path = 0

forest[patl][path] = 'P'

chrisl = user_A - 1
chrish = user_B - 1

forest[chrisl][chrish] = 'C'
for width in forest:
    print(width)

while time != 10:

    p_check = 0

    while p_check != 1:
        p_move = random.randint(1,8)

        if p_move == 1:
            if patl + 1 > 0:
                continue                    #done
            else:
                patl -= 1
                forest[patl][path] = 'P'
                print("Pat moved north!")
                p_check = 1

        elif p_move == 2:
            if patl + 1 > user_B:           #done
                continue
            else:
                patl += 1
                forest[patl][path] = 'P'
                print("Pat moved south!")
                p_check = 1

        elif p_move == 3:
            if path + 1 > user_A:           #done
                continue
            else:
                path += 1
                forest[patl][path] = 'P'
                print("Pat moved east!")
                p_check = 1

        elif p_move == 4:
            if path - 1 < 0:                #done
                continue
            else:
                path -= 1
                forest[patl][path] = 'P'
                print("Pat moved west!")
                p_check = 1

        elif p_move == 5:
            if patl + 1 > 0 or path + 1 > user_A:   #done
                continue
            else:
                patl += 1
                path += 1
                forest[patl][path] = 'P'
                print("Pat moved northeast")
                p_check = 1

        elif p_move == 6:
            if patl + 1 > 0 or path - 1 < 0:        #done
                continue
            else:
                patl -= 1
                path -= 1
                forest[patl][path] = 'P'
                print("Pat moved northwest")
                p_check = 1

        elif p_move == 7:
            if patl + 1 > user_B or path + 1 > user_A:  #done
                continue
            else:
                patl += 1
                path += 1
                forest[patl][path] = 'P'
                print("Pat moved southeast")
                p_check = 1

        else:
            if patl + 1 > user_B or path - 1 < 0:       #done
                continue
            else:
                patl -= 1
                path -= 1
                forest[patl][path] = 'P'
                print("Pat moved southwest")
                p_check = 1


################################################
    c_check = 0

    while c_check != 1:
        c_move = random.randint(1,8)

        if c_move == 1:
            if chrisl + 1 > 0:
                continue
            else:
                chrisl -= 1
                print("Chris moved north!")
                forest[chrisl][chrish] = 'C'
                c_check += 1
                time += 1

        elif c_move == 2:
            if chrisl + 1 >= user_B:
                continue
            else:
                chrisl += 1
                print("Chris moved south!")
                forest[chrisl][chrish] = 'C'
                c_check += 1
                time += 1

        elif c_move == 3:
            if chrish + 1 >= user_A:
                continue
            else:
                chrish += 1
                print("Chris moved east!")
                forest[chrisl][chrish] = 'C'
                c_check += 1
                time += 1

        elif c_move == 4:
            if chrish - 1 < 0:
                continue
            else:
                chrish -= 1
                print("Chris moved west!")
                forest[chrisl][chrish] = 'C'
                c_check += 1
                time += 1

        elif c_move == 5:
            if chrisl + 1 > 0 or chrish + 1 >= user_A:
                continue
            else:
                chrisl += 1
                chrish += 1
                print("Chris moved northeast")
                forest[chrisl][chrish] = 'C'
                c_check += 1
                time += 1

        elif c_move == 6:
            if chrisl + 1 > 0 or chrish - 1 < 0:
                continue
            else:
                chrisl -= 1
                chrish -= 1
                print("Chris moved northwest")
                forest[chrisl][chrish] = 'C'
                c_check += 1
                time += 1

        elif c_move == 7:
            if chrisl + 1 >= user_B or chrish + 1 >= user_A:
                continue
            else:
                chrisl += 1
                chrish += 1
                print("Chris moved southeast")
                forest[chrisl][chrish] = 'C'
                c_check += 1
                time += 1
        else:
            if chrisl + 1 >= user_B or chrish - 1 < 0:
                continue
            else:
                chrisl += 1
                chrish -= 1
                print("Chris moved southwest")
                forest[chrisl][chrish] = 'C'
                c_check += 1
                time += 1

for width in forest:
    print(width)

#print(user_A) #Get rid of this, for testing purposes
#print(user_B)
