import 'package:flutter/material.dart';

class ErrorPage extends StatelessWidget {
  const ErrorPage({Key? key, required this.text}) : super(key: key);
  static const routeName = '/error';
  final String text;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Erro'),
      ),
      body: Center(
        child: Text(text),
      ),
    );
  }
}
