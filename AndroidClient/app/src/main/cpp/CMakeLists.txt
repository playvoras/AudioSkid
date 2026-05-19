cmake_minimum_required(VERSION 3.22.1)
project("audio-skid")

set(CMAKE_BUILD_TYPE Release)

set(CMAKE_CXX_FLAGS_RELEASE
    "-Ofast -flto"
    "-march=armv8-a+simd -mtune=cortex-a55"
    "-ffast-math -funroll-loops"
    "-fomit-frame-pointer -fvisibility=hidden"
    "-fno-stack-protector -fno-exceptions -fno-rtti"
    "-fvectorize -fslp-vectorize"
)

set(CMAKE_SHARED_LINKER_FLAGS_RELEASE
    "-flto -Wl,--gc-sections -Wl,--icf=all"
)

add_library(audio-skid SHARED
    native-lib.cpp
)

target_link_libraries(audio-skid
    log
    aaudio
)