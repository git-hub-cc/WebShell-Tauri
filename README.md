# Tauri + Vue 3
$env:ANDROID_HOME="C:\Users\User\AppData\Local\Android\Sdk"
$env:NDK_HOME="$env:ANDROID_HOME\ndk\<ndk版本>"
$env:JAVA_HOME="C:\Users\User\.jdks\<jdk版本>"

$env:RUSTUP_DIST_SERVER="https://mirrors.tuna.tsinghua.edu.cn/rustup"
$env:RUSTUP_UPDATE_ROOT="https://mirrors.tuna.tsinghua.edu.cn/rustup/rustup"




PS C:\Users\User\IdeaProjects\WebShell-Tauri> npm create tauri-app@latest claims

> npx
> create-tauri-app claims

✔ Identifier · club.ppmc.claims
✔ Choose which language to use for your frontend · TypeScript / JavaScript - (pnpm, yarn, npm, deno, bun)
✔ Choose your package manager · npm

Template created! To get started run:
cd claims
npm install
npm run tauri android init

For Desktop development, run:
npm run tauri dev

For Android development, run:
npm run tauri android dev

# 签名
https://v2.tauri.app/zh-cn/distribute/sign/android/#_top

PS C:\Users\User\IdeaProjects\WebShell-Tauri> keytool -genkey -v -keystore $env:USERPROFILE\upload-keystore.jks -storetype JKS -keyalg RSA -keysize 2048 -validity 10000 -alias upload
输入密钥库口令:  
再次输入新口令:
您的名字与姓氏是什么?
[Unknown]:  cc
您的组织单位名称是什么?
[Unknown]:  cc
您的组织名称是什么?
[Unknown]:  cc
您所在的城市或区域名称是什么?
[Unknown]:  cc
您所在的省/市/自治区名称是什么?
[Unknown]:  cc
该单位的双字母国家/地区代码是什么?
CN=cc, OU=cc, O=cc, L=cc, ST=cc, C=cc是否正确?
[否]:  y

正在为以下对象生成 2,048 位RSA密钥对和自签名证书 (SHA256withRSA) (有效期为 10,000 天):
CN=cc, OU=cc, O=cc, L=cc, ST=cc, C=cc
输入 <upload> 的密钥口令
(如果和密钥库口令相同, 按回车):
再次输入新口令:
[正在存储C:\Users\User\upload-keystore.jks]

Warning:
JKS 密钥库使用专用格式。建议使用 "keytool -importkeystore -srckeystore C:\Users\User\upload-keystore.jks -destkeystore C:\Users\User\upload-keystore.jks -deststoretype pkcs12" 迁移到行业标准格式 PKCS12。



