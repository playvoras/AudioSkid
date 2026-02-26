cmake_minimum_required(VERSION 3.10)
project(AudioSkidServer)
add_executable(AudioSkidServer main.cpp)
target_link_libraries(AudioSkidServer ws2_32 ole32 mmdevapi avrt)
