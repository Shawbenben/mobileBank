 import '@/assets/main.css'
 import 'animate.css';
 import * as ElementPlusIconsVue from '@element-plus/icons-vue'

import { createApp } from 'vue' // 引入 createApp 方法
import App from '@/App.vue'     // 引入 App.vue 组件

// 导入路由
import router from '@/router'

const app = createApp(App)

// 应用路由
app.use(router)
app.mount('#app')

//引入图标
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    app.component(key, component)
}