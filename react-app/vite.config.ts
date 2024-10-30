/// <reference types="vitest" />

import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'
import { configDefaults } from 'vitest/config'

export default defineConfig({
  plugins: [react()],
  test: {
    globals: true,
    environment: 'jsdom',
    setupFiles: './setup.ts',
    exclude: [...configDefaults.exclude],
  },
  server: {
    proxy: {
      "/api": {
        target: "http://localhost:8080"
      }
    }
  }
} as any)