import { defineConfig } from "vite";

export default defineConfig({

  /* Required for GitHub Pages */
  base: "/CSCE548-Project1/",

  server: {
    port: 5173,
    open: true
  },

  build: {
    outDir: "dist"
  }

});
