cmake_minimum_required(VERSION 3.22.1)
project("audio-skid")
add_library(audio-skid SHARED native-lib.cpp)
target_link_libraries(audio-skid log aaudio)
